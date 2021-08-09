# JetpackComposePokedex is now Compédex
A little bit more complete Jetpack Compose to help me improve in learning it.

## Primary Technologies/Libraries Used:
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

### Known Bugs:
 <ol>
    <li>Loading screen might chug along randomly for a second.</li>
    <li>There are times where the LazyVerticalGrid + Pager combo jump to the second page and don't render the first page unless you scroll.</li>
    <li>Some Pokemon information might be wrong or missing (Gen 8) but that is from the API. I did fix some of them but it required hardcoding.</li>
</ol>