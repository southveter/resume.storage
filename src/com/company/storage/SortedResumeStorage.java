package com.company.storage;

import com.company.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cic56 on 05.06.2017.
 */
public class SortedResumeStorage extends AbstactArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    protected void insert(Resume resume, int index) {
        index = -index - 1;
        for (int i = 0; i < size - index; i++) {
            resumes[size - i] = resumes[size - i - 1];
        }
        resumes[index] = resume;
    }



    @Override
    protected void feelDeleted(int index) {
        for (int i = index; i < size; i++) {
            if(i < MAX_LENTH-1) {
                resumes[i] = resumes[i + 1];
            }
        }
    }


    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "temp");
        return Arrays.binarySearch(resumes, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
