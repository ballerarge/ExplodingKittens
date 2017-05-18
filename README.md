Definition of Done:

    Boundary Value Analysis Guidelines: www.exampler.com/testing-com/writings/catalog.pdf

    1. All boolean functions that check if a user can perform an action are tested with the rules for Booleans in Boundary Value Analysis.
    
    2. All counts (hand size, deck size, card inclusions) are tested with the rules for Counts in Boundary Value Analysis.
    
    3. All intervals (See The Future, Pairs, Three of a Kinds, Five of a Kinds, putting cards into the deck) are tested with the rules for Intervals in Boundary Value Analysis.
    
    4. All strings (Card identifiers) are tested with the rules for Strings in Boundary Value Analysis.
    
    5. All collections (lists of cards, lists of players, etc) are tested with the rules for Sizes of Collections in Boundary Value Analysis.
    
    6. Selection of elements in a collection (players hands) are tested with the rules for Using an Element of a Sequencable Collection in Boundary Value Analysis.
    
    7. Subsets of collections (Pairs, Three of a Kinds, Five of a Kinds) are tested with the rules for Using a Subset of a Collection in Boundary Value Analysis.
    
    8. All pairs of counts and intervals are tested with the rules for Pairs of Counts/Intervals in Boundary Value Analysis
    
    9. All pairs of collections (players' hands) are tested with the rules for Pairs of Collections in Boundary Value Analysis. 
    
Edge Cases for Rules:

DRAWING CARDS
	EXPLODING KITTEN CARD DRAWN
		1. If no "Defuse" card in hand, game lost. Kitten card does not go back in deck.
			-If one player remains after person loses, game is over and remaining player wins.
			-Test case: Player draws Exploding Kitten card and has no defuse cards.
			Player is then removed from the game, Exploding Kitten Card removed from game, 
			game continues with next person's turn.

		2. If "Defuse" card is played to counteract, "Defuse" card goes on discard pile and 
		Kitten card is put by player back into deck at any location.
			-Test case: Player draws Exploding Kitten card and has defuse card
			in hand. Defuse card is put onto discard pile. Exploding kitten card put into deck.
				-Test case: Exploding kitten card put on top of deck. Verify it is on top of deck.
				-Test case: Exploding kitten card put on bottom of deck. Verify it is on bottom of deck.
				-Test case: Exploding kitten card tried to put somewhere outside of deck. Verify that 
				exception is thrown and proper message is given to user.
    
PUTTING CARDS ONTO DISCARD PILE
	-Test case: One card is put onto discard pile. Discard pile grows by one. Player's
	hand decreases by one.
	-Test case: Player plays a pair. Discard pile grows by two. Player's hand decreases
	by two
	-Test case: Player plays a three of a kind. Discard pile grows by three. Player's
	hand decreases by three.
	-Test case: Player plays five cards at once. Discard pile grows by five. Player's
	hand decreases by five.

PLAYING CARDS
	DEFUSE CARD PLAYED
		1. If "Exploding Kitten" was last card drawn, and it was drawn by player with defuse card
		that was played, then defuse card will negate the exploding kitten and put it back into the
		deck.

		2. If "Exploding Kitten" was not the last card drawn, Defuse card is not allowed to be
		played onto the discard pile.

	CARDS WITHOUT INSTRUCTIONS (CWI) PLAYED
		1. CWI is not allowed to be played by itself onto discard pile.

		2. CWI can be played onto discard pile with card of same type. Invoke Pair Method.

		3. CWI can be played onto discard pile with two other cards of same type. Invoke Three Of
		A Kind Method.

		4. CWI can be played onto discard pile with group of five cards, provided none of the cards
		are of the same type or description.

	NOPE CARD PLAYED
		1. Nope is not allowed to be played in response to drawing an Exploding Kitten.
			- Test case: Player draws Exploding Kitten, other players cannot play Nope card.
		2. Nope is not allowed to be played in response to a Defuse card going in the discard pile.
			- Test case: Player plays Defuse Card, other players cannot respond with Nope card.
		3. Nope can be played when it is not a person's turn.
			- Multiple Test Cases: Player plays Pair, Three of Kind, 5 set, Nope card,
			Attack card, See the future card, Skip card, Favor Card, Shuffle card. 
			Nope card will negate their effects, cards will go to discard pile, play will
			continue with user who played original card.

	ATTACK CARD PLAYED
		1. When attack card is played, current player's turn ends.
			-Test Case: Play attack card onto discard pile,
			turn ends and next player begins their turn.
			-Test Case: Attack card was played before current attack card was
			played. In this case, make sure that the turn counter is emptied
			for current player and the next player begins their turn.
		2. When attack card is played, next player gains two turn counters to keep
		track of turns remaining.
			- Test case: Play attack card, end current turn 
			(goes to next player), make sure that when
			next turn is ended it is still that players turn.
			
	SKIP CARD PLAYED
		1. When skip card is played, current player's turn ends.
			-Test Case: Have it be current player's turn, have them put skip
			card in discard pile. The draw step should be skipped and then the
			next player's turn should begin (provided an attack card was not 
			played on the previous turn)
		2. Skip card is played, but attack card was played on previous turn.
			-Test Case: Have it be current player's turn, have them put skip
			card in discard pile. The draw step should be skipped, but the next
			turn should still be the current player's turn. Their counter should
			decrease for keeping track of their turns, and this turn should be
			treated like a normal turn.

	FAVOR CARD PLAYED
		1. Select a player to give you a card. Player selected gives a card.
			- Test case: Player selected has 0 cards in hand. This should
			result in the card having no effect and going into the discard
			pile.
			- Test case: Player selected has 1 card in hand. The player selected
			should give up their one card and have 0 cards remaining in hand.
			Player who played favor card gains the card in their hand (hand card count goes up by 1)
			Favor card then goes to discard pile.
			- Test case: Player selected has more than 1 card in hand. Player
			selected picks one of their cards to give up to player with favor
			card. Player selected loses card in hand, and player who played
			favor card gains the selected card. Favor card goes to discard pile.

	SHUFFLE CARD PLAYED
		1. Shuffle the Deck randomly without viewing any of the cards.
			-Test case: Run shuffle on the deck. Make sure that after shuffling,
			deck has same number of cards as it did beforehand.
			-(Can't actually simulate shuffling, because deck could be in same
			order it was when it started. Just run a few test cases to ensure
			that the order gets mixed up most of the time.

	SEE THE FUTURE CARD PLAYED
		1. Peek at the top 3 cards from the draw pile, put them back in same order.
			-Test case: Draw the top three cards. Verify that the user can see
			the cards drawn, and verify that the deck has three cards less.
			-Test case: Draw the top three cards. Verify that the cards can
			be seen, and then place the cards back in the same order they were
			drawn. Verify the deck is the same size as before the cards were
			viewed.
			-Test case: Check(draw) the top three cards. Record the cards in the order
			that they were drawn. Put the cards back on top of the deck. Pick
			the three cards off one by one to verify they were put back in the
			same order.
			-Test case: There are more than 3 cards in the deck. Check(draw) the top 
			three cards, and verify that the deck has three less cards.
			-Test case: There are exactly 3 cards in the deck. Check(draw) the top
			three cards, and verify that the deck has 0 cards left.
			-Test case: There are less than 3 cards in the deck. Check(draw) out
			the deck and verify that there are 0 cards left in the deck.
			
Priority System
    Similar to Magic: The Gathering, our system will have a priority system in place for
        handling the complex interactions of Nope cards. After a player plays a card, 
        priority will have to be passed to each other player before that card can be
        resolved, as to give each player a chance to Nope their card. Nopes will only be
        able to target things already in the priority stack, and if there is every a case
        for a Nope being on the stack and not having a valid target, it will be considered
        played and will be discarded.
