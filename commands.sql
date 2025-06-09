-- ALTER TABLE training_field DROP COLUMN training_field_id;
CREATE TABLE training_courses (
                                  id BIGINT PRIMARY KEY,
                                  dept_root_id INTEGER REFERENCES handbook_department(dept_root_id),
                                  appoint_id INTEGER REFERENCES handbook_position(appoint_id),
                                  training_field_id INTEGER REFERENCES training_field(id)
);

INSERT INTO training_courses (dept_root_id, appoint_id, training_field_id) VALUES
                                                                               (2647, 1595, 144),
                                                                               (2647, 1595, 194),
                                                                               (2647, 1595, 350),
                                                                               (2647, 1595, 378),
                                                                               (2647, 1595, 436),
                                                                               (2647, 1595, 272),
                                                                               (2647, 1626, 144),
                                                                               (2647, 1626, 194),
                                                                               (2647, 1626, 350),
                                                                               (2647, 1626, 378),
                                                                               (2647, 1626, 436),
                                                                               (2647, 1626, 378),
                                                                               (2647, 1593, 144),
                                                                               (2647, 1593, 350),
                                                                               (2647, 1593, 436),
                                                                               (2647, 1593, 378),
                                                                               (2647, 1547, 144),
                                                                               (2647, 1547, 194),
                                                                               (2647, 1547, 350),
                                                                               (2647, 1547, 378),
                                                                               (2647, 1547, 26),
                                                                               (2647, 1547, 272),
                                                                               (2647, 1550, 297),
                                                                               (2647, 1550, 144),
                                                                               (2647, 1550, 186),
                                                                               (2647, 1550, 350),
                                                                               (2647, 1728, 144),
                                                                               (2647, 1728, 350),
                                                                               (2647, 1585, 378),
                                                                               (2647, 1585, 144),
                                                                               (2647, 1585, 350),
                                                                               (2647, 1563, 460),
                                                                               (2647, 1563, 603),
                                                                               (2647, 1563, 378),
                                                                               (2647, 1563, 297),
                                                                               (2647, 1563, 350),
                                                                               (2647, 1563, 144),
                                                                               (2647, 1563, 194),
                                                                               (2647, 1575, 378),
                                                                               (2647, 1575, 350),
                                                                               (2647, 1575, 47),
                                                                               (2647, 1575, 144),
                                                                               (2647, 1575, 113);

SELECT * FROM handbook_position p WHERE p.appoint_name like 'Пожарно-технический минимум' ORDER BY p.appoint_id ASC;

SELECT * FROM persons_cand p WHERE p.d_in = now();