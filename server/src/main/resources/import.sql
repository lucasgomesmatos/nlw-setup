INSERT INTO tb_habits (created_ad, title) VALUES ('2023-02-03 21:54:24.628868', 'Beber 2 litros de água');
INSERT INTO tb_habits (created_ad, title) VALUES ('2023-02-03 21:54:24.628868', 'Exercitar pela manhã');
INSERT INTO tb_habits (created_ad, title) VALUES ('2023-02-03 21:54:24.628868', 'Dormir 10h');

INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (1, 1);
INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (2, 1);
INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (3, 1);

INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (3, 2);
INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (4, 2);
INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (5, 2);

INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (1, 3);
INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (2, 3);
INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (3, 3);
INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (4, 3);
INSERT INTO tb_habits_week_days (week_day, habit_id) VALUES (5, 3);

INSERT INTO tb_days (date) VALUES ('2023-02-04 21:54:24.628868');
INSERT INTO tb_days (date) VALUES ('2023-02-05 21:54:24.628868');
INSERT INTO tb_days (date) VALUES ('2023-02-06 21:54:24.628868');

INSERT INTO tb_day_habit (day_fk, habit_fk) VALUES (1, 1);
INSERT INTO tb_day_habit (day_fk, habit_fk) VALUES (2, 1);
INSERT INTO tb_day_habit (day_fk, habit_fk) VALUES (2, 2);