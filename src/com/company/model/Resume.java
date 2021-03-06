package com.company.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by cic56 on 01.06.2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume  implements Comparable<Resume>, Serializable{
    private static final long serialVersionUID = 1L;
    //unique identifier
    private  String uuid;
    private String fullName;

    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume() {
    }
    public Resume(String fullName) {
        this(UUID.randomUUID().toString(),fullName);
    }

    public Resume(String uuid, String fullName){
        Objects.requireNonNull(uuid, "uuid must be null");
        Objects.requireNonNull(fullName, "fullName must be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }


    public String getContdact(ContactType type) {
        return contacts.get(type);
    }

    public Section getSections(SectionType type) {
        return sections.get(type);
    }

    public void addContact(ContactType type, String value){
        contacts.put(type,value);
    }
    public void addSection(SectionType type, Section value){
        sections.put(type,value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }
}
