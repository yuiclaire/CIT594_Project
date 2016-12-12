# CIT594_Project

This project serves as a tour guide for kids in philadelphia. It stores detailed information, including location,category, contact numbers, name and etc, about places in philly. Our app has mainly three features.You need to import jxbrowser library (download and follow the installation instructions here: https://www.teamdev.com/jxbrowser) to execute our program and main function is in Main class. 

1. Search: In homepage, user could choose desired categorie(Theaters, Parks, Museums, Universities, Libraries, Historic Sites) then search for positions that fall in this category. A google map will pop up after you click search button on homepage and you will see red marks that pinned to all positions of this category. In left side bar,if you want to search for a particular place, you can clink search then enter keyword in text field to filter results. The markers will change according to your input in real time. If you want to fix the markers on the map, you need to click stop then so that the input in text field will not influence the map. 
           If you click on a marker or put your mouse at the bottom of the marker, you will see datailed information about this palce. If you need do comparision, you can click one marker and move you mouse to another marker to chech each information.

2. Recommend: Similar to search, you need to choose category first in home page and then click recommend. Again, a new google map will pop up. By clicking the button(set a marker), a initialzed marker will show up. You can drag the marker to wherever you want and then click recommend button on the bottom, nearby positions of this category will be marked.

3. Blogs: This part gives a brief description of several recommended palces to children to visit in philly. You can scan these blogs by clicking prev, next button and can leave for homepage by clicking return button.

Interface:
Google Map javascript API: This interface is used for display and munipulation of map in our program.

Class:

1. Destination: This is a super class for all positions in our database. 
2. HistoricSites, Libraries, Museum, Parks, Theaters, Universities: They are subclasses of Destinations.
3. RecommendPage: This class defines functions related to recommend.
4. SearchPage: This class defines functions related to search.
5. Manager: This class loads files and generates accordingly objects into our program. We use HashMap to store these objects by using their id as key.
6. Blog1,2,3,4,5: This class implements Blog interface and show brief discriptions to users.
7. HomePage: This class defines the home page of our app.
8. Main: This is the entry to our app.

We use hashmap, arrayList to manage our data. We also make graphic user interface to build up a friendly interface to users to use. 
In blog part, we use thread to make pictures change  automatically. 
