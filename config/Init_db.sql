CREATE TABLE contacts
(
  id INTEGER DEFAULT nextval('contacts_id_seq'::regclass) PRIMARY KEY NOT NULL,
  type TEXT NOT NULL,
  value TEXT NOT NULL,
  resume_uuid CHAR(36) NOT NULL REFERENCES resume ON DELETE CASCADE
);
CREATE TABLE resume
(
  uuid CHAR PRIMARY KEY NOT NULL,
  full_name TEXT NOT NULL
);
CREATE UNIQUE INDEX contacts_uuid_type_index
ON contacts (resume_uuid, type);
