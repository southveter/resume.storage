package config;

import storage.SqlStorage;
import storage.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    protected static final File PROPS = new File("config/resume.properties");
    private static final Config INSTANCE = new Config();

    private final File storageDir;
    private final Storage storage;

    public  static Config get() {return  INSTANCE;}

    public Config() {
        try(InputStream is = new FileInputStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);

            this.storageDir = new File(props.getProperty("storage.dir"));
            this.storage = new SqlStorage(props.getProperty("db.url"),props.getProperty("db.user"),props.getProperty("db.password"));
        }catch (IOException e){
            throw  new IllegalStateException("Invalid config file" + PROPS.getAbsolutePath());
        }
    }
}
