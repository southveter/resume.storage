package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import sql.SqlHelper;
import storage.Storage;

import java.rmi.activation.ActivationGroup_Stub;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {
    public final SqlHelper sqlhelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        sqlhelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl,dbUser,dbPassword));
    }

    @Override
    public void clear() {
        sqlhelper.execute("DELETE FROM resume");
    }

    @Override
    public void update(Resume r) {
        sqlhelper.execute("UPDATE resume r SET full_name = ? WHERE uuid = ?", ps ->{
            ps.setString(2, r.getUuid());
            ps.setString(1, r.getFullName());
            if(ps.executeUpdate() == 0){
                throw new NotExistStorageException(r.getUuid());
            }
            return null;
        });

    }

    @Override
    public void save(Resume r) {
       sqlhelper.execute("INSERT INTO resume (uuid, full_name) VALUES (?,?)", ps ->{
           ps.setString(1, r.getUuid());
           ps.setString(2, r.getFullName());
           if(ps.executeUpdate() == 0){
               throw new ExistStorageException(r.getUuid());
           }
           return null;
       });
    }
    @Override
    public void delete(String uuid) {
        sqlhelper.execute("DELETE FROM resume WHERE uuid = ?", ps -> {
            ps.setString(1, uuid);
            if(ps.executeUpdate() == 0) {
                throw new NotExistStorageException(uuid);
            }
            return null;
        });
    }


    @Override
    public Resume get(String uuid) {
       return sqlhelper.execute("SELECT * FROM resume WHERE uuid =?", ps ->{
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid,rs.getString("full_name"));
        });

    }


    @Override
    public List<Resume> getAllSorted() {
        return sqlhelper.execute("SELECT * FROM resume r ORDER BY full_name,uuid", ps ->{
            ResultSet rs = ps.executeQuery();
            List<Resume> resumes = new ArrayList<>();
            while (rs.next()){
                resumes.add(new Resume(rs.getString("uuid"),rs.getString("full_name")));
            }
            return resumes;
        });

    }

    @Override
    public int size() {
        return  sqlhelper.execute("SELECT count(*) FROM resume", st ->{
           ResultSet rs = st.executeQuery();
           return  rs.next() ? rs.getInt(1):0;
        });
    }
}
