SET FOREIGN_KEY_CHECKS = 0;
SET FOREIGN_KEY_CHECKS = 1;

 -- ---------------------------------------------------------------------------
 --  Padecimientos
 -- ---------------------------------------------------------------------------
 INSERT INTO `tb-padecimientos` (id, nombre, descripcion) VALUES
        (1, 'Intolerancia a la lactosa', 'Dificultad a la hora de digerir lactosa presente en los lacteos'),
        (2, 'Celiaquia', 'Reaccion inmure al gluten del trigo, cebada y centeno'),
        (3, 'Diabetes', 'Niveles elevados de azucar en sangre, requiere controlar carbohidratos'),
        (4, 'Hipertension', 'Presion arterial alta, requiere controlar el consumo de sodio'),
        (5, 'Colesterol alto', 'Exceso de colesterol, requiere reducir grasas saturadas'),
        (6, 'Gastritis', 'Inflamacion del estomago, evitar irritantes y acidos'),
        (7, 'Anemia', 'Falta de hierro, se recomienda aumentar alimentos ricos en hierro'),
        (8, 'Obesidad', 'Exceso de peso, requiere control calorico y de azucares'),
        (9, 'Insuficiencia renal', 'Funcion renal reducida, control de sodio, potasio y proteinas'),
        (10, 'Alergia al mani', 'Reaccion alergica al cacahuate y derivados');

 -- ---------------------------------------------------------------------------
 --  Alimentos por padecimiento  (ahora en tb-alimentos)
 -- ---------------------------------------------------------------------------

 -- 1) Intolerancia a la lactosa
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (1, 'Leche sin lacteos', 'Apta porque no contiene lactosa', 'RECOMENDADO'),
         (1, 'Pollo', 'Libre de lactosa', 'RECOMENDADO'),
         (1, 'Arroz', 'Libre de lactosa', 'RECOMENDADO'),
         (1, 'Queso maduro', 'Contiene pocas lactosa, consumir en pequeñas cantidades', 'PRECAUCION'),
         (1, 'Leche entera', 'Alta en lactosa', 'EVITAR'),
         (1, 'Helado de leche', 'Alta en lactosa', 'EVITAR');

 -- 2) Celiaquia
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (2, 'Arroz', 'Naturalmente libre de gluten', 'RECOMENDADO'),
         (2, 'Pollo', 'Libre de gluten', 'RECOMENDADO'),
         (2, 'Frijoles', 'Libre de gluten', 'RECOMENDADO'),
         (2, 'Avena', 'Solo si esta certufucado libre de gluten', 'PRECAUCION'),
         (2, 'Pan de trigo', 'Contiene gluten', 'EVITAR'),
         (2, 'Pasta de trigo', 'Contiene gluten', 'EVITAR');

 -- 3) Diabetes
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (3, 'Vegetales verdes', 'Bajo indice glucemico', 'RECOMENDADO'),
         (3, 'Pollo', 'Proteina sin azucar', 'RECOMENDADO'),
         (3, 'Avena', 'Libera energia lentamente', 'RECOMENDADO'),
         (3, 'Fruta entera', 'Con moderacion por el azucar natural', 'PRECAUCION'),
         (3, 'Refrescos azucarados', 'Elevan el azucar rapidamente', 'EVITAR'),
         (3, 'Pasteles', 'Alto contenido de azucar', 'EVITAR');

 -- 4) Hipertension
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (4, 'Vegetales frescos', 'Bajo en sodio', 'RECOMENDADO'),
         (4, 'Banano', 'Rico en potasio', 'RECOMENDADO'),
         (4, 'Avena', 'Ayuda a la salud del corazon', 'RECOMENDADO'),
         (4, 'Queso', 'Moderar su contenido de sodio', 'PRECAUCION'),
         (4, 'Embutidos', 'Muy altos en sodio', 'EVITAR'),
         (4, 'Comidas enlatadas', 'Alta en sodio', 'EVITAR');

 -- 5) Colesterol alto
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (5, 'Avena', 'Ayuda a reducir el colesterol', 'RECOMENDADO'),
         (5, 'Pescado', 'Aporta grasa saludables', 'RECOMENDADO'),
         (5, 'Vegetales', 'Bajo en grasas', 'RECOMENDADO'),
         (5, 'Huevos', 'Moderar la yema', 'PRECAUCION'),
         (5, 'Frituras', 'Altas en grasa saturada', 'EVITAR'),
         (5, 'Mantequilla', 'Alta en grasa saturada', 'EVITAR');

 -- 6) Gastritis
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (6, 'Arroz', 'Suave para el estomago', 'RECOMENDADO'),
         (6, 'Pollo cocido', 'Facil de digerir', 'RECOMENDADO'),
         (6, 'Manzana', 'Suave y nutritiva', 'RECOMENDADO'),
         (6, 'Cafe', 'Moderar porque puede irritar', 'PRECAUCION'),
         (6, 'Comida picante', 'Irrita la mucosa del estomago', 'EVITAR'),
         (6, 'Citricos', 'Acidos, pueden causar molestia', 'EVITAR');

 -- 7) Anemia
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (7, 'Frijoles', 'Ricos en hierro', 'RECOMENDADO'),
         (7, 'Espinaca', 'Rica en hierro', 'RECOMENDADO'),
         (7, 'Carne roja magra', 'Buena fuente de hierro', 'RECOMENDADO'),
         (7, 'Te', 'Reduce la absorcion de hierro', 'PRECAUCION'),
         (7, 'Refrscos', 'No aportan nutrientes', 'EVITAR'),
         (7, 'Exceso de lacteos', 'Reducen la absorcion de hierro', 'EVITAR');

 -- 8) Obesidad
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (8, 'Vegetales', 'Bajos en calorias', 'RECOMENDADO'),
         (8, 'Pollo a la plancha', 'Proteina baja en grasa', 'RECOMENDADO'),
         (8, 'Fruta', 'Saludable con moderacion', 'RECOMENDADO'),
         (8, 'Pan integral', 'Moderar la porcion', 'PRECAUCION'),
         (8, 'Comida rapida', 'Alta en calorias y grasa', 'EVITAR'),
         (8, 'Bebida azucarada', 'Muchas calorias vacias', 'EVITAR');

 -- 9) Insuficiencia renal
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (9, 'Arroz', 'Bajo en potasio', 'RECOMENDADO'),
         (9, 'Manzana', 'Bajo en potasio', 'RECOMENDADO'),
         (9, 'Coliflor', 'Bajo en potasio', 'RECOMENDADO'),
         (9, 'Carne', 'Controlar la cantidad de proteina', 'PRECAUCION'),
         (9, 'Banano', 'Alto en potasio', 'EVITAR'),
         (9, 'Embutidos', 'Altos en potasio', 'EVITAR');

 -- 10) Alergia al mani
 INSERT INTO `tb-alimentos` (padecimiento_id, food, description, nivel_recomendacion) VALUES
         (10, 'Arroz', 'Seguro sin mani', 'RECOMENDADO'),
         (10, 'Pollo', 'Seguro sin mani', 'RECOMENDADO'),
         (10, 'Frutas', 'Seguras sin mani', 'RECOMENDADO'),
         (10, 'Productos a granel', 'Riesgo de contaminacion cruzada', 'PRECAUCION'),
         (10, 'Mani', 'Causa la reaccion alergica', 'EVITAR'),
         (10, 'Mantequilla de mani', 'Contiene mani', 'EVITAR');
