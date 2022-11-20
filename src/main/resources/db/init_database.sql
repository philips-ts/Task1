DROP TABLE IF EXISTS analytics;
CREATE TABLE analytics(
    id int AUTO_INCREMENT,
    dateTime TIMESTAMP,
    order_id INT,
    processed BOOLEAN,
    PRIMARY KEY (id)
);

DROP TRIGGER IF EXISTS analytics_trigger;
CREATE TRIGGER analytics_trigger AFTER INSERT ON orders
    FOR EACH ROW BEGIN
    INSERT INTO analytics SET dateTime=NOW(), order_id=NEW.order_id, processed=TRUE;
END;

DROP PROCEDURE IF EXISTS buyHistory;
CREATE PROCEDURE buyHistory(IN id INT)
BEGIN
    SELECT * FROM orders WHERE order_id=id;
end;
