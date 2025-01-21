CREATE TABLE IF NOT EXISTS respuestas (

    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico_id INT,
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    autor_id INT,
    solucion BOOLEAN DEFAULT FALSE,

     FOREIGN KEY (topico_id) REFERENCES topicos(id),
     FOREIGN KEY (autor_id) REFERENCES usuarios(id)

)