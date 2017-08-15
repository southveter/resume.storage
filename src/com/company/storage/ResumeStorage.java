package com.company.storage;

import com.company.model.Resume;

/**
 * Created by cic56 on 01.06.2017.
 */
public class ResumeStorage extends AbstactArrayStorage {


    @Override
    protected void feelDeleted(int index) {
        resumes[index] = resumes[size - 1];
    }

    @Override
    protected void insert(Resume resume, int index) {
        resumes[size] = resume;
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(resumes[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }



}
