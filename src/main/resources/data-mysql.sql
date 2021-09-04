-- insert into countries table
INSERT INTO countries(COUNTRY_NAME) VALUES
    ('Romania'),
    ('Italy'),
    ('Spain'),
    ('Kenya'),
    ('Australia'),
    ('Canada');

-- insert into regions table
INSERT INTO regions(REGION_NAME, COUNTRY_ID) VALUES
    ('Dobrogea', 1),
    ('Maramures',1),
    ('Catalonia',3),
    ('Valea Prahovei',1),
    ('Queensland',5),
    ('Ontario',6);

-- insert into destinations table
INSERT INTO destinations(DESTINATION_NAME, REGION_ID) VALUES
    ('Mamaia', 1),
    ('Satu Mare',2),
    ('Barcelona',3),
    ('Sinaia',4),
    ('Busteni',4),
    ('Techirghiol',1);

-- insert into sport_types table
INSERT INTO sport_types(SPORT_NAME) VALUES
    ('Surfing'),
    ('Extreme skiing'),
    ('Parachuting'),
    ('Snowboarding');

-- insert into events_info table
INSERT INTO events_info(SPORT_TYPE_ID, PRICE_PER_DAY, DESTINATION_ID, BEGIN_DATE, END_DATE) VALUES
     (1, 22.22, 1, '2021-06-06', '2021-07-06'),
     (1, 15, 1, '2021-07-07', '2021-09-06'),
     (2, 33.33, 4, '2021-11-06', '2021-12-06'),
     (3, 55.55, 3, '2021-05-06', '2021-07-06'),
     (4, 66.66, 5, '2021-10-06', '2021-12-06'),
     (4, 77.77, 5, '2021-09-06', '2021-10-06');

