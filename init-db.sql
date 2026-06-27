-- Create the 'connection' table for login authentication
CREATE TABLE IF NOT EXISTS `connection` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `login` VARCHAR(50) NOT NULL,
  `pass` VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Insert test data
INSERT INTO `connection` (`login`, `pass`) VALUES
('med', 'aksachlii'),
('user1', 'password1'),
('admin', 'admin123');

-- Create other tables as needed for the application
CREATE TABLE IF NOT EXISTS `filiere` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `nom` VARCHAR(100) NOT NULL,
  `description` TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `module` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `nom` VARCHAR(100) NOT NULL,
  `filiere_id` INT,
  FOREIGN KEY (filiere_id) REFERENCES filiere(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `matiere` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `nom` VARCHAR(100) NOT NULL,
  `module_id` INT,
  FOREIGN KEY (module_id) REFERENCES module(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `enseignant` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `nom` VARCHAR(100) NOT NULL,
  `prenom` VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `nom` VARCHAR(100) NOT NULL,
  `prenom` VARCHAR(100) NOT NULL,
  `filiere_id` INT,
  FOREIGN KEY (filiere_id) REFERENCES filiere(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `salle` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `numero` VARCHAR(50) NOT NULL,
  `capacite` INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `semestre` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `numero` INT NOT NULL,
  `filiere_id` INT,
  FOREIGN KEY (filiere_id) REFERENCES filiere(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `seance` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `matiere_id` INT,
  `enseignant_id` INT,
  `salle_id` INT,
  `date_seance` DATE,
  `heure_debut` TIME,
  `heure_fin` TIME,
  FOREIGN KEY (matiere_id) REFERENCES matiere(id),
  FOREIGN KEY (enseignant_id) REFERENCES enseignant(id),
  FOREIGN KEY (salle_id) REFERENCES salle(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `enseignement` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `enseignant_id` INT,
  `matiere_id` INT,
  FOREIGN KEY (enseignant_id) REFERENCES enseignant(id),
  FOREIGN KEY (matiere_id) REFERENCES matiere(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

