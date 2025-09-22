-- =============================
-- Flyway Migration: V1__init.sql
-- =============================

-- Table: tb_users
CREATE TABLE tb_users (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          password_hash VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Unique constraint on email
ALTER TABLE tb_users
    ADD CONSTRAINT users_email_key UNIQUE (email);

-- Table: tb_vaults
CREATE TABLE tb_vaults (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           user_id BIGINT,
                           name VARCHAR(255),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT vaults_user_id_fkey FOREIGN KEY (user_id) REFERENCES tb_users(id)
);

-- Table: tb_notes
CREATE TABLE tb_notes (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          vault_id BIGINT,
                          path VARCHAR(255),
                          filename VARCHAR(255),
                          content TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT notes_vault_id_fkey FOREIGN KEY (vault_id) REFERENCES tb_vaults(id)
);

-- Indexes for tb_notes
CREATE INDEX idx_notes_path ON tb_notes(path);
CREATE INDEX idx_notes_vault ON tb_notes(vault_id);
