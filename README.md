  Definition of Done:  
    Boundary Value Analysis Guidelines: [link] (www.exampler.com/testing-com/writings/catalog.pdf)  
    :cat:1. All boolean functions that check if a user can perform an action are tested with the rules for Booleans in Boundary Value Analysis.  
    :bomb:2. All counts (hand size, deck size, card inclusions) are tested with the rules for Counts in Boundary Value Analysis.  
    :cat:3. All intervals (See The Future, Pairs, Three of a Kinds, Five of a Kinds, putting cards into the deck) are tested with the rules for Intervals in Boundary Value Analysis.  
    :bomb:4. All strings (Card identifiers) are tested with the rules for Strings in Boundary Value Analysis.  
    :cat:5. All collections (lists of cards, lists of players, etc) are tested with the rules for Sizes of Collections in Boundary Value Analysis.  
    :bomb:6. Selection of elements in a collection (players hands) are tested with the rules for Using an Element of a Sequencable Collection in Boundary Value Analysis.  
    :cat:7. Subsets of collections (Pairs, Three of a Kinds, Five of a Kinds) are tested with the rules for Using a Subset of a Collection in Boundary Value Analysis.  
    :bomb:8. All pairs of counts and intervals are tested with the rules for Pairs of Counts/Intervals in Boundary Value Analysis  
    :cat:9. All pairs of collections (players' hands) are tested with the rules for Pairs of Collections in Boundary Value Analysis.  
<br><br>Edge Cases for Rules:  
	<br>:+1:EXPLODING KITTEN CARD DRAWN:  
	    1. If no "Defuse" card in hand, game lost. Kitten card does not go back in deck.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/03198c9c5419a614348ef1287403100634d552da)  
			-If one player remains after person loses, game is over and remaining player wins.:skull:  
			-Test case: Player draws Exploding Kitten card, no defuse cards.
		    Player removed from the game, Exploding Kitten Card removed from game, game continues with next person's turn. (https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/03198c9c5419a614348ef1287403100634d552da)  
	    2. If "Defuse" card is played to counteract, "Defuse" card goes on discard pile and 
		Kitten card is put by player back into deck at any location.   
			-Test case: Player draws Exploding Kitten card and has defuse card
			in hand. Defuse card is put onto discard pile. Exploding kitten card put into deck.  (https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/f9ef7d32467c2ef22f1bd878e9778ca5fcc369c1)  
				-Test case: Exploding kitten card put on top of deck. Verify it is on top of deck.:skull:  
				-Test case: Exploding kitten card put on bottom of deck. Verify it is on bottom of deck.  (https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/f9ef7d32467c2ef22f1bd878e9778ca5fcc369c1)  
				-Test case: Exploding kitten card tried to put somewhere outside of deck. Verify that 
				exception is thrown and proper message is given to user.:skull:  
    <br><br>:+1:PUTTING CARDS ONTO DISCARD PILE  
	-Test case: One card is put onto discard pile. Discard pile grows by one. Player's
	hand decreases by one. (https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/417b9f0aa3a50302b606af74a49abf161b67153a)  
	-Test case: Player plays a pair. Discard pile grows by two. Player's hand decreases
	by two. (https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/9c7fb9af5c8a68ee42407df3ac938dcfa414ee0c)  
	-Test case: Player plays a three of a kind. Discard pile grows by three. Player's
	hand decreases by three. (https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/9fc6f1659c03f74e423333550c8861abd30451bd)  
	-Test case: Player plays five cards at once. Discard pile grows by five. Player's
	hand decreases by five. (https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/70d14f869a6c1140abe5ba12f07667613b15816e)  
	<br><br>:+1:DEFUSE CARD PLAYED  
	    1. If "Exploding Kitten" was last card drawn, and it was drawn by player with defuse card
		that was played, then defuse card will negate the exploding kitten and put it back into the
		deck.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/e73b9243a9b42a490d83032a5192c600b742e370)  
	    2. If "Exploding Kitten" was not the last card drawn, Defuse card is not allowed to be
		played onto the discard pile.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/61a05cc44c67f7fb53d2b3f83e110a2686659a48)  
	<br><br>:+1:CARDS WITHOUT INSTRUCTIONS (CWI) PLAYED  
	    1. CWI is not allowed to be played by itself onto discard pile.:skull:  
	    2. CWI can be played onto discard pile with card of same type. Invoke Pair Method.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/9c7fb9af5c8a68ee42407df3ac938dcfa414ee0c)  
	    3. CWI can be played onto discard pile with two other cards of same type. Invoke Three Of A Kind Method.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/9fc6f1659c03f74e423333550c8861abd30451bd)  
	    4. CWI can be played onto discard pile with group of five cards, provided none of the cards are of the same type or description.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/70d14f869a6c1140abe5ba12f07667613b15816e)  
	<br><br>:+1:NOPE CARD PLAYED  
	    1. Nope is not allowed to be played in response to drawing an Exploding Kitten.  
	    	- Test case: Player draws Exploding Kitten, other players cannot play Nope card.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/dc6b2db406a366727f299a945ea0b1c0800ce149)  
	    2. Nope is not allowed to be played in response to a Defuse card going in the discard pile.  
		    - Test case: Player plays Defuse Card, other players cannot respond with Nope card.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/a7e571fee5798f598aa7c90d85d7be9ed995057b)  
	    3. Nope can be played when it is not a person's turn.  
		    - Multiple Test Cases: Player plays Pair, Three of Kind, 5 set, Nope card,
		    Attack card, See the future card, Skip card, Favor Card, Shuffle card.
			Nope card will negate their effects, cards will go to discard pile, play will
			continue with user who played original card.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/b65ed5234a866de3dfb5426faf488609c851256c)  
	<br><br>:+1:ATTACK CARD PLAYED  
	    1. When attack card is played, current player's turn ends.  
			-Test Case: Play attack card onto discard pile,
			turn ends and next player begins their turn.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/0048aac508c5fddde6e368dd918134ef0f5eea0a)  
			-Test Case: Attack card was played before current attack card was
			played. In this case, make sure that the turn counter is emptied
			for current player and the next player begins their turn.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/9d8954c42d376c3692d58281b1ffd603e40d4116)  
	    2. When attack card is played, next player gains two turn counters to keep
	    track of turns remaining.  
	    	- Test case: Play attack card, end current turn 
	    	(goes to next player), make sure that when
			next turn is ended it is still that players turn.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/8b5fd630741918cb2a13e52aa92f95c1c9009d75)  
	<br><br>:+1:SKIP CARD PLAYED  
	    1. When skip card is played, current player's turn ends.
			-Test Case: Have it be current player's turn, have them put skip
			card in discard pile. The draw step should be skipped and then the
			next player's turn should begin (provided an attack card was not 
			played on the previous turn)(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/2b559eff4f9b58c36d07175f25894f85d65e5872)  
	    2. Skip card is played, but attack card was played on previous turn.
			-Test Case: Have it be current player's turn, have them put skip
			card in discard pile. The draw step should be skipped, but the next
			turn should still be the current player's turn. Their counter should
			decrease for keeping track of their turns, and this turn should be
			treated like a normal turn.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/2eace3c3aafab55a0d5039d2bd84e8abb4bf471a)  
	<br><br>:+1:FAVOR CARD PLAYED  
	    1. Select a player to give you a card. Player selected gives a card.  
		    - Test case: Player selected has 0 cards in hand. This should
			result in the card having no effect and going into the discard
			pile.  (https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/cebb1f2ad51997a821c822be81febbb0cfde1b6a)  
		    - Test case: Player selected has 1 card in hand. The player selected
			should give up their one card and have 0 cards remaining in hand.
			Player who played favor card gains the card in their hand (hand card count goes up by 1)
			Favor card then goes to discard pile.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/cebb1f2ad51997a821c822be81febbb0cfde1b6a)  
		    - Test case: Player selected has more than 1 card in hand. Player
			selected picks one of their cards to give up to player with favor
			card. Player selected loses card in hand, and player who played
			favor card gains the selected card. Favor card goes to discard pile.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/cebb1f2ad51997a821c822be81febbb0cfde1b6a)  
	<br><br>:+1:SHUFFLE CARD PLAYED  
	    1. Shuffle the Deck randomly without viewing any of the cards.
			-Test case: Run shuffle on the deck. Make sure that after shuffling,
			deck has same number of cards as it did beforehand.((https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/3e4151249d16f2b69596b01ca95d43de5ce251f3)  
			-(Can't actually simulate shuffling, because deck could be in same
			order it was when it started. Just run a few test cases to ensure
			that the order gets mixed up most of the time.)  
	<br><br>:+1:SEE THE FUTURE CARD PLAYED  
	    1. Peek at the top 3 cards from the draw pile, put them back in same order.  
			-Test case: There are more than 3 cards in the deck. Check the top three cards.
                        Verify they are the top cards in the deck.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/746d96dfd7d7eea5848e2ed981105c1d20fa534c)  
			-Test case: There are exactly 3 cards in the deck. Check the top three cards.
                        Verify they are the top cards in the deck.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/746d96dfd7d7eea5848e2ed981105c1d20fa534c)  
			-Test case: There are less than 3 cards in the deck. Look at the remaining cards.
                        Verify they are the top cards in the deck.(https://ada.csse.rose-hulman.edu/wilejd/exploding-kittens/commit/746d96dfd7d7eea5848e2ed981105c1d20fa534c)  
			
<br>Priority System
    Similar to Magic: The Gathering, our system will have a priority system in place for
        handling the complex interactions of Nope cards. After a player plays a card, 
        priority will have to be passed to each other player before that card can be
        resolved, as to give each player a chance to Nope their card. Nopes will only be
        able to target things already in the priority stack, and if there is every a case
        for a Nope being on the stack and not having a valid target, it will be considered
        played and will be discarded.:skull:  

