Scenario:       As user I can serach some info on wiki
Description:    Bad practice
Given open Wikipedia main page
When select English language in search language field
And input Behavior-driven development text in search field
And click search button '->'
Then user redirect on article result page
And Behavior-driven development article display on the page
And article language is English

Scenario:       As Ukrainian user I can select any language on wikipedia.org
Description:    Select any language for search on wikipedia.org
Given open Wikipedia main page
When user searches Behavior-driven development text in English language
Then Behavior-driven development article is found




