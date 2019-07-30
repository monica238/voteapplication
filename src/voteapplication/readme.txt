Classes and Sequence of operations
---------------------------------
Voter
- Accept the voter details 
- Validate voter identity
Candidate
- Accept Candidate details
Admin
- Set initial uname,password
- validate uname and password and return Yes/No
CastVote
- Capture candidate and voter details
Ballot
- accept candidate list
- check if ballot process is complete - Yes/No

Main
{
- Create VoterList, CandidateList, CastVoteList, Ballot

-> Check admin validity
-> Allow user to select option
-> if use selects 1
	- accept Voter details
	- Create voter object
	- store voter details in the object
	- add voter object to voterList
- Allow user to select the option
-> if user selects 2
	- accept Candidate details
	- Create candidate object
	- store candidate details in the object
	- add candidate object to candidateList
-> if user selects 3
	- create ballot object
	- add candidate list to ballot object
	- set ballot creation is completed
-> if user selects 4
	- check if ballot process is complete
	- if Yes
		- accept voter id
		- validate if voter id is existing in the voterList
		- if Valid Voter
			- create castvote object
			- show candidate list from Ballot
			- accept the candidate selection
			- create cndidate object  
			- assign candidate from ballot to new candidate object
			- assign voter object and candidate object to cast vote
			- add castvote object to castvoteList
			- show success message
		- if Invalid
			- show invalid message
	- if No
		- show ballot not created message
		

}
