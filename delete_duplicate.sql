CREATE TABLE training_results_backup AS SELECT * FROM training_results;
CREATE TABLE training_field_backup AS SELECT * FROM training_field;

SELECT count(*) FROM training_results;
SELECT count(*) FROM training_results_backup;

SELECT count(*) FROM training_field;
SELECT count(*) FROM training_field_backup;

SELECT training_field, COUNT(*) as duplicate_count
FROM training_field
GROUP BY training_field
HAVING COUNT(*) > 1
ORDER BY duplicate_count DESC;

SELECT training_field FROM training_field WHERE id = 811;

SELECT id, training_field FROM training_field WHERE training_field IS NULL OR training_field = '';

DELETE FROM training_results
WHERE training_field IN (SELECT id FROM training_field WHERE training_field IS NULL OR training_field = '');

DELETE FROM training_field WHERE training_field IS NULL OR training_field = '';

UPDATE training_results
SET training_field = 732
WHERE training_field = 738;

SELECT count(*) FROM training_results WHERE training_field = 732;

DELETE FROM training_field
WHERE training_field.id IN (738, 797, 359, 811, 290, 668, 698, 546, 455, 58, 209);