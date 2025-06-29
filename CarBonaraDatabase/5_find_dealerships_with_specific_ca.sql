USE car_dealership;

-- 5. Find all Dealerships that have a certain car type (i.e. Red Ford Mustang)
SELECT d.*
FROM dealerships d 
JOIN inventory i ON d.dealership_id = i.dealership_id
JOIN vehicles v ON i.VIN=v.VIN
WHERE v.make = "Ford"
	AND v.model = "Fusion"
    AND v.color = "White";