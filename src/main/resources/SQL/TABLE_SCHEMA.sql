CREATE TABLE IF NOT EXISTS Gifts (
	gift_id TEXT,
	gift_name TEXT,
	member_level_min INTEGER,
	PRIMARY KEY(gift_id)
);

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

CREATE TABLE IF NOT EXISTS GiftRecords (
	transaction_id TEXT,
	gift_id TEXT,
	amount INTEGER,
	PRIMARY KEY(transaction_id, gift_id),
	FOREIGN KEY(transaction_id) REFERENCES Transactions(transaction_id),
	FOREIGN KEY(gift_id) REFERENCES Gifts(gift_id)
);