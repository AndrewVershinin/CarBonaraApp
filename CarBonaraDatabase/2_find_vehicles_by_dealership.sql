USE car_dealership;



-- 2. Find all vehicles for a specific dealership
SELECT v.*
FROM vehicles v
JOIN inventory i ON v.VIN = i.VIN
WHERE i.dealership_id = 1;