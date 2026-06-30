CREATE OR REPLACE FUNCTION check_section_capacity()
RETURNS TRIGGER AS $$
DECLARE
	current_count INTEGER;
	capacity INTEGER;
BEGIN
	SELECT COUNT(*) INTO current_count
	FROM enrollments
	WHERE section_id = NEW.section_id and status = 'active';

	SELECT max_capacity INTO capacity
	FROM sections
	WHERE id = NEW.section_id;

	IF current_count >= capacity THEN
		RAISE EXCEPTION 'Section % has reached max capacity', NEW.section_id;
    END IF;

	RETURN NEW;
END;
$$ Language plpgsql;

CREATE TRIGGER trg_check_capacity
BEFORE INSERT ON enrollments
FOR EACH ROW
EXECUTE FUNCTION check_section_capacity();
	