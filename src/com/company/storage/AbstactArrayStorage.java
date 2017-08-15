package com.company.storage;

import com.company.exceptions.StorageException;
import com.company.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cic56 on 05.06.2017.
 */
public abstract class AbstactArrayStorage extends AbstractStorage<Integer> {
    public static final int MAX_LENTH = 10000;
    protected Resume[] resumes = new Resume[MAX_LENTH]; //array
    protected int size = 0;


    public int size() {
        return size;
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            resumes[i] = null;
        }
        size = 0;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return  searchKey >= 0;
    }


    @Override
    protected void doSave(Resume r, Integer index) {
            if(size == MAX_LENTH){
                throw new StorageException("Storage is overflow", r.getUuid());
            }else{
                insert(r, index);
                size++;
            }
    }
    @Override
    protected void doUpdate(Resume r, Integer index) {
        resumes[index] = r;
    }


    @Override
    protected Resume doGet(Integer index) {
        return resumes[index];
    }

    @Override
    protected void doDelete(Integer index) {
            feelDeleted(index);
            resumes[size - 1] = null;
            size--;
    }

//    @Override
//    public void update(Resume resume) {
//        int index = getSearchKey(resume.getUuid());
//        if (index > -1) {
//            resumes[index] = resume;
//        } else {
//           throw new NotExistStorageException(resume.getUuid());
//             // System.out.println("this resume " + resume.getUuid() + "  is apsent");
//        }
//    }


//    @Override
//    public Resume get(String uuid) {
//        int index = getSearchKey(uuid);
//        if (index > -1) {
//            return resumes[index];
//        } else {
//            throw new NotExistStorageException(uuid);
////            System.out.println("this resume " + uuid + "  is apsent");
////            return null;
//        }
//    }
//
//    @Override
//    public Resume[] getAll() {
//        Resume[] all = new Resume[size];
//        for (int i = 0; i < size; i++) {
//            all[i] = resumes[i];
//        }
//        return all;
//    }


//    @Override
//    public void save(Resume resume) {
//        if (!(size < MAX_LENTH)) {
//            throw new StorageException("storage overflow!",resume.getUuid());
//               //return;
//        }
//        int index = getSearchKey(resume.getUuid());
//        if (index > -1) {
//            throw new ExistStorageException(resume.getUuid());
////            System.out.println("resume with this  " + resume.getUuid() + " already exist!");
//
//        } else {
//            insert(resume, index);
//            size ++;
//        }
//    }

//    @Override
//    public void delete(String uuid) {
////        for (int i = 0; i < size; i++) {
////            if (uuid.equals(resumes[i].getUuid())) {
////                resumes[i] = resumes[size - 1];
////                resumes[size - 1] = null;
////                size--;
////            }
////
////        }
//        int index = getSearchKey(uuid);
//        if (index > -1) {
//            feelDeleted(index);
//            size--;
//        } else {
//            throw new NotExistStorageException(uuid);
//            //System.out.println("this resume " + uuid + "  is apsent");
//        }
//    }

    //    @Override
//    public void update(Resume resume) {
//        super.update(resume);
//    }
    public  List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(resumes, 0, size));
    }

    protected abstract void feelDeleted(int index);

    protected abstract void insert(Resume resume, int index);

    protected abstract Integer getSearchKey(String uuid);
}
