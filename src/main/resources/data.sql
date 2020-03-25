DROP TABLE IF EXISTS projects;

CREATE TABLE projects (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  url VARCHAR(250) NOT NULL,
  owner VARCHAR(250) NOT NULL,
  stars INTEGER(250) DEFAULT NULL
);

INSERT INTO projects (url, owner, stars) VALUES
  ('https://github.com/edomingues/jersey.git', 'Jersey', 2349),
  ('https://github.com/Jetty.git', 'Jetty', 10393),
  ('https://github.com/edo/Tomcat.git', 'Tomcat', 45999);