/*Table Description*/

/*Admn Table*/
create table Authentication
(
username varchar(20),
password varchar(20)
);


/*Voter Table*/
create table Voter
(
voterId int,
voterFirstName varchar(20),
voterLastName varchar(20),
voterLocation varchar(20),
voterAge int,
voterAadharNumber int
);


/*Candidate Table*/
create table Candidate
(
candidateId int,
candidateFirstName varchar(20),
candidatePartyName varchar(20),
candidateLocation varchar(20),
candidateAge int,
candidateVoteCount int
);

/* Ballot Table */
create table Ballot
(
ballotId int,
createdby varchar(20),
createddate date
);


/* Ballot and Candidate */
create table Ballot
(
ballotId int,
candidateId int
);


/* Cast Vote Table */
create table CastVote
(
castVoteId int,
voterId int,
candidateId int,
dateOfVoting date
);

