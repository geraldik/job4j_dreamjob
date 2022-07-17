create TABLE post (
   id SERIAL PRIMARY KEY,
   name TEXT,
   description TEXT,
   created TIMESTAMP,
   visible BOOL,
   city_id INT
);