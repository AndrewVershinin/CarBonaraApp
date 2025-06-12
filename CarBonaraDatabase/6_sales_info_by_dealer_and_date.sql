USE car_dealership;

-- 6. Get all sales information for a specific dealer for a specific date range
SELECT s.*, i.dealership_id
FROM sales_contracts s 
JOIN inventory i ON s.VIN = i.VIN
WHERE i.dealership_id = 2
	AND s.sale_date BETWEEN "2025-01-01" AND "2025-12-31"


