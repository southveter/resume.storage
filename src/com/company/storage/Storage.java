package com.company.storage;

import com.company.model.Resume;

import java.io.File;
import java.util.List;

/**
 * Created by cic56 on 01.06.2017.
 */
public interface Storage {
    //crud
    void save(Resume resume);
    void delete(String uuid);
    void update(Resume resume);
    Resume get(String uuid);
    List<Resume> getAllSorted();
    void clear();
    int size();

    /**
     * Created by cic56 on 10.07.2017.
     */
}
