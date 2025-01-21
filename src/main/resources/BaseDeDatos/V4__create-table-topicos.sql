CREATE TABLE IF NOT EXISTS topicos (

    id INT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(255) NOT NULL,
        mensaje TEXT NOT NULL,
        fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
        estado VARCHAR(20) NOT NULL,
        autor_id INT,
        curso_id INT,

        FOREIGN KEY (autor_id) REFERENCES usuarios(id),
        FOREIGN KEY (curso_id) REFERENCES cursos(id)

)