CREATE TABLE IF NOT EXISTS Songs (
	song_id TEXT,
	name TEXT,
	artist TEXT,
	album TEXT,
	genre TEXT,
	duration INTEGER,
	date_created NUMERIC,
        date_modified NUMERIC,
	PRIMARY KEY(song_id)
);

CREATE TABLE IF NOT EXISTS Users (
	user_id TEXT,
	privillage INTEGER,
	name TEXT,
	pw_hash TEXT,
	first_name TEXT,
	last_name TEXT,
	member_point INTEGER,
	member_level TEXT,
	date_created NUMERIC,
        date_modified NUMERIC,
	PRIMARY KEY(user_id)
);

CREATE TABLE IF NOT EXISTS RegisteredSessions (
        session_id TEXT,
        session_key TEXT,
        room_size TEXT,
        head_count INTEGER,
        session_date TEXT,
        session_start_time TEXT,
        session_end_time TEXT,
        date_created NUMERIC,
        date_modified NUMERIC,
        PRIMARY KEY(session_id)
);

CREATE TABLE IF NOT EXISTS Transactions (
	transaction_id TEXT,
        session_id TEXT,
	discount REAL,
	final_price REAL,
	member_id TEXT,
	member_level_atm TEXT,
	staff_id TEXT,
        status INTEGER,
        date_created NUMERIC,
        date_modified NUMERIC,
	PRIMARY KEY(transaction_id),
	FOREIGN KEY(member_id) REFERENCES Users(user_id),
        FOREIGN KEY(session_id) REFERENCES RegisteredSessions(session_id),
	FOREIGN KEY(staff_id) REFERENCES Users(user_id)
);

INSERT OR IGNORE INTO RegisteredSessions 
VALUES 
('RS001', '', 'S', 1, '2021-08-23', '14:00', '16:00', 1629717928, 1629717928),
('RS002', 'aaaaaa', 'M', 1, '2021-08-24', '20:00', '22:00', 1629717992, 1629717992),
('RS003', 'bbbbbb', 'L', 1, '2021-08-25', '11:00', '13:00', 1629718014, 1629719060);

INSERT OR IGNORE INTO Songs
VALUES 
('S001', 'See You Again', 'Wiz Knalifa ft. Charlie Puth', 'See You Again', 'Jazz', 237, strftime('%s', 'now'), strftime('%s', 'now')),
('S002', 'Sorry', 'Justin Bieber', 'Sorry', 'Chill', 198, strftime('%s', 'now'), strftime('%s', 'now')),
('S003', 'Uptown Funk', 'Mark Ronson ft. Bruno Mars', 'Uptown Funk', 'Chill', 270, strftime('%s', 'now'), strftime('%s', 'now')),
('S004', 'Blank Space', 'Taylor Swift', 'Blank Space', 'Jazz', 30, strftime('%s', 'now'), strftime('%s', 'now')),
('S005', 'Shake It Off', 'Taylor Swift', 'Shake It Off', 'Jazz', 120, strftime('%s', 'now'), strftime('%s', 'now')),
('S006', 'Lean On', 'Major Lazer & Dj Shake ft. Mo', 'Shakey', 'Rock', 180, strftime('%s', 'now'), strftime('%s', 'now')),
('S007', 'Hello', 'Adele', 'ClassicalFlock', 'Rock', 89, strftime('%s', 'now'), strftime('%s', 'now')),
('S008', 'Roar', 'Kary Perry', 'Perry', 'Rock', 200, strftime('%s', 'now'), strftime('%s', 'now')),
('S009', 'Sugar', 'Maroon 5', 'Ivy', 'Rock', 177, strftime('%s', 'now'), strftime('%s', 'now')),
('S010', 'All About That Bass', 'Meghan Trainor', 'Flock', 'Jazz', 199, strftime('%s', 'now'), strftime('%s', 'now'));

INSERT OR IGNORE INTO Users 
VALUES
('U001', 0, 'kazexu', 'handsome', 'Philip', 'Khaw', 100, 'N', strftime('%s', 'now'), strftime('%s', 'now')),
('U002', 0, 'mintong', 'chenxiang', 'Ong', 'Xiang', 34, 'S', strftime('%s', 'now'), strftime('%s', 'now')),
('U003', 0, 'user1', 'user123', 'Xiao', 'Ming', 230, 'G', strftime('%s', 'now'), strftime('%s', 'now')),
('U004', 0, 'zikang', 'lzikang', 'Loo', 'Kang', 10000, 'G', strftime('%s', 'now'), strftime('%s', 'now')),
('U005', 0, 'kirito', 'saogame', 'Kirigaya', 'Kazuto', 123, 'S', strftime('%s', 'now'), strftime('%s', 'now')),
('U006', 1, 'admin1', 'admin123', 'Lim', 'Hang', 0, '-', strftime('%s', 'now'), strftime('%s', 'now')),
('U007', 1, 'admin2', 'tokyolim', 'Teng', 'Huat', 0, '-', strftime('%s', 'now'), strftime('%s', 'now')),
('U008', 1, 'admin3', 'malaysia', 'Deng', 'Wang', 0, '-', strftime('%s', 'now'), strftime('%s', 'now')),
('U009', 1, 'admin4', 'hairshampoo', 'Hwoo', 'Sang', 0, '-', strftime('%s', 'now'), strftime('%s', 'now')),
('U010', 1, 'admin5', 'taruc', 'Wang', 'Yangg', 0, '-', strftime('%s', 'now'), strftime('%s', 'now'));

INSERT OR IGNORE INTO Transactions VALUES
('T0001', 'RS001', 0.0, 8.0, 'U001', 'Normal', 'U006', 1, 1629717928, 1629717928),
('T0002', 'RS002', 0.75, 14.25, 'U002', 'Silver', 'U006', 1, 1629717992, 1629717992),
('T0003', 'RS003', 1.2, 10.8, 'U004', 'Gold', 'U006', 2, 1629718014, 1629719060);