Classes and Sequence of operations - modified
---------------------------------
Voter
- Accept the voter details                            -COMPLETED
- Validate voter identity                             -COMPLETED
Candidate
- Accept Candidate details                            -COMPLETED
Admin
- Set initial uname,password                           -COMPLETED
- validate uname and password and return Yes/No        -COMPLETED
CastVote
- Capture candidate and voter details                  
Ballot
- accept candidate list
- check if ballot process is complete - Yes/No          -COMPLETED

Main
{
- Create VoterList, CandidateList, CastVoteList, Ballot

-> Check admin validity
-> Allow user to select option
-> if use selects 1
	- accept Voter details                              -COMPLETED
	- Create voter object                               -COMPLETED
	- store voter details in the object                 -COMPLETED
	- add voter object to voterList                     -COMPLETED
- Allow user to select the option
-> if user selects 2
	- accept Candidate details               -COMPLETED
	- Create candidate object                -COMPLETED
	- store candidate details in the object  -COMPLETED
	- add candidate object to candidateList  -COMPLETED
-> if user selects 3
	- create ballot object                   -COMPLETED
	- add candidate list to ballot object    -COMPLETED
	- set ballot creation is completed
-> if user selects 4
	- check if ballot process is complete      -COMPLETED
	- if Yes
		- accept voter id                                        -COMPLETED
		- validate if voter id is existing in the voterList      -COMPLETED
		- if Valid Voter
			- create castvote object                          -COMPLETED
			- show candidate list from Ballot                 -COMPLETED
			- accept the candidate selection                  -COMPLETED
			- create cndidate object  
			- assign candidate from ballot to new candidate object
			- assign voter object and candidate object to cast vote     -COMPLETED
			- add castvote object to castvoteList                       -COMPLETED
			- show success message                                      -COMPLETED
		- if Invalid
			- show invalid message                                       -COMPLETED
	- if No
		- show ballot not created message
		

}
