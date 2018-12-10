CREATE TABLE guest (
  [ID] INT IDENTITY,
  [first_name] varchar(20),
  [last_name] varchar(20),
  [password] varchar(20),
  [edit_authorisation] char(1),
  PRIMARY KEY ([ID])
);

CREATE TABLE room (
  [ID] INT IDENTITY,
  [type] varchar(20),
  [capacity] int,
  [room_name] varchar(20),
  PRIMARY KEY ([ID])
);

CREATE TABLE booking (
  [ID] INT IDENTITY,
  [roomID] int,
  [guestID] int,
  [date] date,
  [time] time(0),
  PRIMARY KEY ([ID]),
  CONSTRAINT fk_User_booking FOREIGN KEY (guestID) REFERENCES guest(ID),
  CONSTRAINT fk_Room_Booking FOREIGN KEY (roomID) REFERENCES room(ID)
);
