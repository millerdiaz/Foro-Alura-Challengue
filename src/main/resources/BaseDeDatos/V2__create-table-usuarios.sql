CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL ,
    email VARCHAR(100) NOT NULL UNIQUE,
    clave VARCHAR(250) NOT NULL,
    perfil_id INT,

    FOREIGN KEY (perfil_id) REFERENCES perfiles(id)

)