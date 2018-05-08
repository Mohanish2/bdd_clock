Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: Invalid Time Instance 1
When the time is 24:01:00
Then error message should be shown
Incorrect time for conversion

Scenario: Invalid Time Instance  2
When the time is 24:00:45
Then error message should be shown
Incorrect time for conversion

Scenario: Invalid Time Instance 3
When the time is 25:00:00
Then error message should be shown
Incorrect time for conversion

Scenario: Invalid Time  Instance 4
When the time is 20:66:00
Then error message should be shown
Incorrect time for conversion

Scenario: Invalid Time Instance 5
When the time is 20:00:85
Then error message should be shown
Incorrect time for conversion
