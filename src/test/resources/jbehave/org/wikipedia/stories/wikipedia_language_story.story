Scenario:       Assert that user can select English language on main page
Description:    Select English language for search on wikipedia.org
Given open Wikipedia main page
When select English language
Then English language is selected

Scenario:       As Ukrainian user I can select any language on wikipedia.org
Description:    Select any language for search on wikipedia.org
Given open Wikipedia main page
When user select <language> language
Then selected language is <language>

Examples:
|language|
|Deutsch|
|English|
|Italiano|




