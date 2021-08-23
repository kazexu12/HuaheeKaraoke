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
('RS001', '', 'N', 1, '2021-08-23', '14:00', '16:00', strftime('%s', 'now'), strftime('%s', 'now')),
('RS002', 'aaaaaa', 'N', 1, '2021-08-24', '20:00', '22:00', strftime('%s', 'now'), strftime('%s', 'now')),
('RS003', 'bbbbbb', 'N', 1, '2021-08-25', '11:00', '13:00', strftime('%s', 'now'), strftime('%s', 'now'));

INSERT OR IGNORE INTO Songs
VALUES 
('S001', 'See You Again', 'Wiz Knalifa ft. Charlie Puth', 'See You Again', 'Jazz', 237, strftime('%s', 'now'), strftime('%s', 'now')),
('S002', 'Sorry', 'Justin Bieber', '', 'Chill', 198, strftime('%s', 'now'), strftime('%s', 'now')),
('S003', 'Uptown Funk', 'Mark Ronson ft. Bruno Mars', '', 'Chill', 270, strftime('%s', 'now'), strftime('%s', 'now')),
('S004', 'Blank Space', 'Taylor Swift', '', 'Jazz', 30, strftime('%s', 'now'), strftime('%s', 'now')),
('S005', 'Shake It Off', 'Taylor Swift', '', 'Jazz', 120, strftime('%s', 'now'), strftime('%s', 'now')),
('S006', 'Lean On', 'Major Lazer & Dj Shake ft. Mo', 'Shakey', 'Rock', 180, strftime('%s', 'now'), strftime('%s', 'now')),
('S007', 'Hello', 'Adele', 'ClassicalFlock', 'Rock', 89, strftime('%s', 'now'), strftime('%s', 'now')),
('S008', 'Roar', 'Kary Perry', 'Perry', 'Rock', 200, strftime('%s', 'now'), strftime('%s', 'now')),
('S009', 'Sugar', 'Maroon 5', 'Ivy', 'Rock', 177, strftime('%s', 'now'), strftime('%s', 'now')),
('S010', 'All About That Bass', 'Meghan Trainor', '', 'Jazz', 199, strftime('%s', 'now'), strftime('%s', 'now'));


INSERT OR IGNORE INTO Users
VALUES
('U001', 0, 'admin', 'admin', '', '', -1, 'N', strftime('%s', 'now'), strftime('%s', 'now')),
('U002', 0, 'admin2', 'admin2', 'Ong', 'Chen Xiang', -1, 'N', strftime('%s', 'now'), strftime('%s', 'now')),
('U003', 0, 'admin3', 'admin3', 'Loo', 'Zi Kang', -1, 'N', strftime('%s', 'now'), strftime('%s', 'now'));
