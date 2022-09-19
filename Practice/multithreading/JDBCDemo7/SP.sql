DELIMITER $$
CREATE PROCEDURE sp_insert_candidates(IN cId INT, IN cName VARCHAR(100), IN party VARCHAR(50), IN votes INT)
	BEGIN
		INSERT INTO 
			candidates
		VALUES
			(cId, cName, party, votes)
	END $$
DELIMITER ; 	

DELIMITER $$
CREATE PROCEDURE sp_update_candidates(IN cId INT, IN cParty VARCHAR(50))
	BEGIN
		UPDATE
			candidates
		SET
			party=cParty
		WHERE
			id=cId;
	END $$
DELIMITER ; 	


DELIMITER $$
CREATE PROCEDURE sp_delete_candidate(IN cId INT)
	BEGIN
		DELETE from 
		candidates
		WHERE
			id=cId;
	END $$
DELIMITER ; 	

DELIMITER $$
CREATE PROCEDURE sp_select_candidates()
	BEGIN
		SELECT *
			FROM
			candidates;
	END $$
DELIMITER ; 	

