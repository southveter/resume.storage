package model;

public class Resume  implements  Comparable<Resume>{
    // Unique identifier
    private String uuid;

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }


    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume o) {
        return this.uuid.compareTo(o.getUuid());
    }
}
