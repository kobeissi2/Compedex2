# JetpackComposePokedex is now Compédex
A little bit more complete Jetpack Compose to help me improve in learning it.

## Features:
<ul>
  <li>Fetches all of the Pokemon contained in PokeAPI.</li>
  <li>Extracts color palettes from the sprite and uses that to randomly generate a background and a matching text color.</li>
  <li>Pages to Room DB and uses that when necessary.</li>
  <li>Landscape and Portrait support.</li>
</ul>

### Primary Technologies/Libraries Used:
<ol>
  <li>Kotlin</li>
   <ul>
      <li>Coroutines</li>
      <li>Flows</li>
      <li>Kotlin DSL</li>
   </ul>
  <li>Jetpack Compose</li>
  <li>Navigation</li>
  <li>Google Accompanist</li>
  <ul>
    <li>Swipe Refresh</li>
    <li>Pager</li>
    <li>Navigation Animation</li>
  </ul>
  <li>Dagger Hilt</li>
  <li>Coil KT</li>
  <li>Retrofit</li>
  <li>Moshi</li>
  <li>Room</li>
  <li>Paging 3</li>
  <li>Palette</li>
</ol>
  
## Screenshots:
Portrait:
<p>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/Loading.png" width="200" title="Loading"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/SearchPortrait.png" width="200" title="Search"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/EntriesPortrait.png" width="200" title="Entries"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/DetailsAbout.png" width="200" title="Details"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/DetailsAlt.png" width="200" title="Details"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/DetailsEvolution.png" width="200" title="Evolution"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/DetailsMoves.png" width="200" title="Moves"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/ErrorPortrait.png" width="200" title="Error"/>
</p>

Landscape:
<p>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/EntriesLandscape.png" width="500" title="Entries"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/DetailsLandscape.png" width="500" title="Details"/>
  <img src="https://github.com/kobeissi2/Compedex/blob/main/screenshots/ErrorLandscape.png" width="500" title="Error"/>
</p>

#### Known Bugs/Issues:
 <ol>
    <li><strike>Inital load might take up to 30 seconds.</strike> Loading now takes ~3 seconds on average.</li>
    <li><strike>Loading screen progress bar might chug along randomly.</strike> Improved performance in latest updated.</li>
    <li><strike>There are times where the LazyVerticalGrid + Pager combo jump to the second page and don't render the first page unless you scroll.</strike> Fixed in latest update.</li>
    <li>Some Pokemon information might be wrong or missing (Gen 8) but that is from the API. I did fix some of them but it required hardcoding.</li>
</ol>
