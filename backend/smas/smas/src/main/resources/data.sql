INSERT INTO "tb-padecimientos" (id, nombre, descripcion) VALUES
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

INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('Catalogo', NULL, 1, 'Leche sin lacteos', 'Apta porque no contiene lactosa', 'RECOMENDADO'),
        ('Catalogo', NULL, 1, 'Pollo', 'Libre de lactosa', 'RECOMENDADO'),
        ('Catalogo', NULL, 1, 'Arroz', 'Libre de lactosa', 'RECOMENDADO'),
        ('Catalogo', NULL, 1, 'Queso maduro', 'Contiene pocas lactosa, consumir en pequeñas cantidades', 'PRECAUCION'),
        ('Catalogo', NULL, 1, 'Leche entera', 'Alta en lactosa', 'EVITAR'),
        ('Catalogo', NULL, 1, 'Helado de leche', 'Alta en lactosa', 'EVITAR');

INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('Catalogo', NULL, 2, 'Arroz', 'Naturalmente libre de gluten', 'RECOMENDADO'),
        ('Catalogo', NULL, 2, 'Pollo', 'Libre de gluten', 'RECOMENDADO'),
        ('Catalogo', NULL, 2, 'Frijoles', 'Libre de gluten', 'RECOMENDADO'),
        ('Catalogo', NULL, 2, 'Avena', 'Solo si esta certufucado libre de gluten', 'PRECAUCION'),
        ('Catalogo', NULL, 2, 'Pan de trigo', 'Contiene gluten', 'EVITAR'),
        ('Catalogo', NULL, 2, 'Pasta de trigo', 'Contiene gluten', 'EVITAR');

INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('', NULL, 3, 'Vegetales verdes', 'Bajo indice glucemico', 'RECOMENDADO'),
        ('', NULL, 3, 'Pollo', 'Proteina sin azucar', 'RECOMENDADO'),
        ('', NULL, 3, 'Avena', 'Libera energia lentamente', 'RECOMENDADO'),
        ('', NULL, 3, 'Fruta entera', 'Con moderacion por el azucar natural', 'PRECAUCION'),
        ('', NULL, 3, 'Refrescos azucarados', 'Elevan el azucar rapidamente', 'EVITAR'),
        ('', NULL, 3, 'Pasteles', 'Alto contenido de azucar', 'EVITAR');

INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('', NULL, 4, 'Vegetales frescos', 'Bajo en sodio', 'RECOMENDADO'),
        ('', NULL, 4, 'Banano', 'Rico en potasio', 'RECOMENDADO'),
        ('', NULL, 4, 'Avena', 'Ayuda a la salud del corazon', 'RECOMENDADO'),
        ('', NULL, 4, 'Queso', 'Moderar su contenido de sodio', 'PRECAUCION'),
        ('', NULL, 4, 'Embutidos', 'Muy altos en sodio', 'EVITAR'),
        ('', NULL, 4, 'Comidas enlatadas', 'Alta en sodio', 'EVITAR');


INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('', NULL, 5, 'Avena', 'Ayuda a reducir el colesterol', 'RECOMENDADO'),
        ('', NULL, 5, 'Pescado', 'Aporta grasa saludables', 'RECOMENDADO'),
        ('', NULL, 5, 'Vegetales', 'Bajo en grasas', 'RECOMENDADO'),
        ('', NULL, 5, 'Huevos', 'Moderar la yema', 'PRECAUCION'),
        ('', NULL, 5, 'Frituras', 'Altas en grasa saturada', 'EVITAR'),
        ('', NULL, 5, 'Mantequilla', 'Alta en grasa saturada', 'EVITAR');
INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('', NULL, 6, 'Arroz', 'Suave para el estomago', 'RECOMENDADO'),
        ('', NULL, 6, 'Pollo cocido', 'Facil de digerir', 'RECOMENDADO'),
        ('', NULL, 6, 'Manzana', 'Suave y nutritiva', 'RECOMENDADO'),
        ('', NULL, 6, 'Cafe', 'Moderar porque puede irritar', 'PRECAUCION'),
        ('', NULL, 6, 'Comida picante', 'Irrita la mucosa del estomago', 'EVITAR'),
        ('', NULL, 6, 'Citricos', 'Acidos, pueden causar molestia', 'EVITAR');


INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('', NULL, 7, 'Frijoles', 'Ricos en hierro', 'RECOMENDADO'),
        ('', NULL, 7, 'Espinaca', 'Rica en hierro', 'RECOMENDADO'),
        ('', NULL, 7, 'Carne roja magra', 'Buena fuente de hierro', 'RECOMENDADO'),
        ('', NULL, 7, 'Te', 'Reduce la absorcion de hierro', 'PRECAUCION'),
        ('', NULL, 7, 'Refrscos', 'No aportan nutrientes', 'EVITAR'),
        ('', NULL, 7, 'Exceso de lacteos', 'Reducen la absorcion de hierro', 'EVITAR');
INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('', NULL, 8, 'Vegetales', 'Bajos en calorias', 'RECOMENDADO'),
        ('', NULL, 8, 'Pollo a la plancha', 'Proteina baja en grasa', 'RECOMENDADO'),
        ('', NULL, 8, 'Fruta', 'Saludable con moderacion', 'RECOMENDADO'),
        ('', NULL, 8, 'Pan integral', 'Moderar la porcion', 'PRECAUCION'),
        ('', NULL, 8, 'Comida rapida', 'Alta en calorias y grasa', 'EVITAR'),
        ('', NULL, 8, 'Bebida azucarada', 'Muchas calorias vacias', 'EVITAR');

INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('', NULL, 9, 'Arroz', 'Bajo en potasio', 'RECOMENDADO'),
        ('', NULL, 9, 'Manzana', 'Bajo en potasio', 'RECOMENDADO'),
        ('', NULL, 9, 'Coliflor', 'Bajo en potasio', 'RECOMENDADO'),
        ('', NULL, 9, 'Carne', 'Controlar la cantidad de proteina', 'PRECAUCION'),
        ('', NULL, 9, 'Banano', 'Alto en potasio', 'EVITAR'),
        ('', NULL, 9, 'Embutidos', 'Altos en potasio', 'EVITAR');

INSERT INTO "tb-planComidas" (plan_name, user_id, padecimientos_id, food, descripcion, nivel) VALUES
        ('', NULL, 10, 'Arroz', 'Seguro sin mani', 'RECOMENDADO'),
        ('', NULL, 10, 'Pollo', 'Seguro sin mani', 'RECOMENDADO'),
        ('', NULL, 10, 'Frutas', 'Seguras sin mani', 'RECOMENDADO'),
        ('', NULL, 10, 'Productos a granel', 'Riesgo de contaminacion cruzada', 'PRECAUCION'),
        ('', NULL, 10, 'Mani', 'Causa la reaccion alergica', 'EVITAR'),
        ('', NULL, 10, 'Mantequilla de mani', 'Contiene mani', 'EVITAR');

