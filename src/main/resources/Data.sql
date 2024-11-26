CREATE TABLE  IF NOT EXISTS tb_cidades (

    id BIGINT AUTO_INCREMENT  PRIMARY KEY,

    municipio VARCHAR(255) NOT NULL,
    mun_uf VARCHAR(255) NOT NULL,
    latitude VARCHAR(255) NOT NULL,
    longitude VARCHAR(255) NOT NULL,
    uf VARCHAR(5) NOT NULL,
    valor VARCHAR(255) NOT NULL
    );


INSERT INTO tb_cidades(
     municipio, mun_uf,latitude,longitude,uf,valor)
    VALUES
    ('ABADIA DE GOIAS', 'ABADIA DE GOIAS - GO','-16,75','-49,43','GO','21125,01396'),
    ('ABADIANIA', 'ABADIANIA - GO','-16,2','-48,7','GO','61561,75617');