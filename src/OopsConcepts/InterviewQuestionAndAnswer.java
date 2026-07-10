//# Skeps SDET I/II — Complete Deep-Dive Study Guide
//*Every concept explained in depth, followed by full Q&A for each topic. Read concept sections first, then drill the Q&A.*
//
//---
//---
//
//# TOPIC 1: MANUAL TESTING FUNDAMENTALS
//
//## Concepts
//
//**SDLC (Software Development Life Cycle)**: The full process of building software — Requirement Gathering → Design → Development → Testing → Deployment → Maintenance. QA is involved from the requirement stage (reviewing for testability/ambiguity) through maintenance (regression on hotfixes).
//
//**STLC (Software Testing Life Cycle)**: The testing-specific phases within SDLC:
//1. **Requirement Analysis** — QA studies requirements, raises queries on ambiguous/testable items.
//2. **Test Planning** — decide scope, approach, tools, timelines, resources (Test Plan document).
//3. **Test Case Design** — write test cases/scenarios, prepare test data.
//4. **Environment Setup** — configure test environment, verify smoke-readiness.
//5. **Test Execution** — run test cases, log defects for failures.
//6. **Test Closure** — evaluate exit criteria, prepare summary report, capture lessons learned.
//
//**Types of Testing (all mentioned in your resume/JD):**
//- **Functional Testing**: Verifies each function of software against requirements (does the feature work as specified).
//- **Smoke Testing**: Quick, shallow check that build is stable enough for deeper testing ("build verification testing").
//- **Sanity Testing**: Narrow, deep check on a specific area after a minor change/fix — confirms that particular fix works without full regression.
//- **Regression Testing**: Re-running existing tests to ensure new code changes haven't broken existing functionality.
//- **Integration Testing**: Verifies interaction between integrated modules/components (e.g., UI talking correctly to API, API talking to DB).
//- **UAT (User Acceptance Testing)**: End-users/business validate the system meets business needs before go-live — typically the final gate before production.
//- **Cross-Browser Testing**: Verifying consistent behavior/appearance across different browsers (Chrome, Firefox, Safari, Edge) and versions.
//- **Exploratory Testing**: Simultaneous learning, test design, and execution — unscripted, relies on tester's domain knowledge and intuition to find issues scripted tests miss.
//- **Ad-hoc Testing**: Informal, random testing without documented test cases, often to try to "break" the system.
//- **Retesting**: Re-executing a specific failed test case after the bug is fixed to confirm the fix (different from regression, which checks *other* areas aren't broken).
//
//**Severity vs Priority (classic interview trap — know the difference cold):**
//- **Severity** = impact of the bug on the system (technical) — Critical/High/Medium/Low.
//- **Priority** = how urgently it needs to be fixed (business) — P1/P2/P3/P4.
//- Example: A spelling mistake on the homepage = Low severity but High priority (visible to all users, embarrassing, quick fix). A crash in a rarely-used admin report = High severity but Low priority (few users affected).
//
//**Test Case vs Test Scenario:**
//- Test Scenario = high-level "what to test" (e.g., "Verify login functionality").
//- Test Case = detailed step-by-step "how to test" with specific steps, test data, and expected results, derived from a scenario.
//
//**Defect Life Cycle**: New → Assigned → Open → Fixed → Retest → Verified → Closed (or Reopened if retest fails; or Deferred/Rejected/Duplicate as alternate paths).
//
//**Bug Report — what a good one contains**: Title, Steps to Reproduce, Expected vs Actual Result, Severity/Priority, Environment (browser/OS/build version), Screenshots/logs/video attachment, and a unique ID.
//
//## Q&A
//
//**Q1. What is the difference between Verification and Validation?**
//Verification = "Are we building the product right?" (static checks — reviews, walkthroughs, checking against specs, no code execution). Validation = "Are we building the right product?" (dynamic testing — actually executing the software against user needs).
//
//**Q2. What is the difference between Smoke and Sanity testing?**
//Smoke = broad and shallow, run on a fresh build to confirm it's stable enough to test further (build acceptance). Sanity = narrow and deep, run after a specific bug fix/minor change to confirm that particular area works, without doing a full regression.
//
//**Q3. What's the difference between Regression and Retesting?**
//Retesting confirms a *specific* bug is actually fixed (same test case, same steps). Regression confirms that fix (or any other code change) hasn't broken *other* unrelated areas of the application.
//
//**Q4. What's in a Test Plan document?**
//Scope (in/out), test objectives, approach/strategy, entry/exit criteria, resources & responsibilities, environment/tools needed, schedule/timelines, risk & mitigation, and deliverables.
//
//**Q5. What are Entry and Exit criteria?**
//Entry criteria = conditions that must be met before testing can begin (e.g., build deployed, smoke test passed, test data ready). Exit criteria = conditions to conclude testing (e.g., X% test cases executed, no open Critical/High bugs, defect density below threshold).
//
//**Q6. How do you write a good test case?**
//Include: Test Case ID, Title, Preconditions, Test Steps (numbered, precise), Test Data, Expected Result, and Priority — written so anyone (not just you) can execute it identically.
//
//**Q7. What is Boundary Value Analysis and Equivalence Partitioning?**
//Equivalence Partitioning: divide input data into valid/invalid partitions and test one representative value per partition (reduces redundant test cases while maintaining coverage). Boundary Value Analysis: test at the edges of these partitions (min, min-1, max, max+1) since bugs cluster at boundaries — e.g., for an age field accepting 18–60, test 17, 18, 60, 61.
//
//**Q8. How do you decide what to test when requirements are unclear or missing?**
//Raise clarifying questions with BA/PM immediately; where unavoidable, rely on domain knowledge, similar existing features, and industry-standard UX conventions, document assumptions explicitly, and validate them with stakeholders before finalizing test cases.
//
//---
//---
//
//# TOPIC 2: SELENIUM WEBDRIVER — DEEP DIVE
//
//## Concepts
//
//**Architecture**: Your test script (Java/Python/etc.) → Selenium Client Library (language bindings) → JSON over HTTP (W3C WebDriver Protocol) → Browser Driver (chromedriver.exe/geckodriver.exe — a small server that translates commands into native browser automation calls) → Actual Browser. Each browser driver implements the W3C spec differently under the hood, which is why driver versions must match browser versions.
//
//**WebElement vs By**: `By` is a locator strategy class (e.g., `By.id("x")`) used to *find* an element; `WebElement` is the actual object representing a found DOM element that you interact with (`.click()`, `.sendKeys()`, `.getText()`).
//
//**findElement vs findElements**: `findElement()` returns the first matching element or throws `NoSuchElementException` if none found. `findElements()` returns a `List<WebElement>` — empty list (not an exception) if none match, making it safer for existence checks.
//
//**Waits — deep explanation**:
//- **Implicit Wait**: `driver.manage().timeouts().implicitlyWait(Duration)` — tells the driver to poll the DOM for a set max time *every time* `findElement`/`findElements` is called, globally, for the life of the driver session.
//- **Explicit Wait**: `WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); wait.until(ExpectedConditions.elementToBeClickable(locator));` — targeted at one specific condition/element, polls every 500ms by default until condition met or timeout.
//- **Fluent Wait**: Same as explicit but lets you customize polling frequency and which exceptions to ignore during polling (e.g., ignore `NoSuchElementException` while waiting).
//- **Why mixing implicit + explicit is dangerous**: If implicit wait is set to 10s and an explicit wait condition also polls, in worst cases the effective wait time can become the *sum*, causing unpredictable delays (documented Selenium anti-pattern).
//
//**Exceptions — deep list**:
//- `NoSuchElementException` — locator matched nothing in DOM.
//- `StaleElementReferenceException` — element reference is no longer attached to DOM (page navigated/refreshed/re-rendered after you located it).
//- `ElementNotInteractableException` — element is in DOM and maybe visible but can't currently be interacted with (e.g., disabled, animating).
//- `ElementClickInterceptedException` — another element (overlay/modal/sticky header) is covering the target at the click coordinates.
//- `TimeoutException` — an explicit wait condition wasn't satisfied within timeout.
//- `NoSuchWindowException` / `NoSuchFrameException` — switching to a window/frame handle that doesn't exist.
//- `InvalidSelectorException` — malformed XPath/CSS.
//
//**Selenium 4 specific upgrades** (very likely to be asked since it's current):
//- Native W3C WebDriver protocol (Selenium 3 used a JSON Wire Protocol that had to be translated — Selenium 4 removed that translation layer, reducing flakiness).
//- **Relative Locators**: `driver.findElement(RelativeLocator.with(By.tagName("button")).above(By.id("footer")))` — locate elements relative to another using `above()`, `below()`, `toLeftOf()`, `toRightOf()`, `near()`.
//- **Chrome DevTools Protocol (CDP) integration** — allows network interception, geolocation override, console log capture directly from Selenium.
//- **Improved Selenium Grid UI** with better observability.
//- **Native Shadow DOM support** via `getShadowRoot()`.
//- **New Window/Tab handling**: `driver.switchTo().newWindow(WindowType.TAB)`.
//
//**Selenium Grid**: A Hub-Node architecture (Selenium 4 also supports a simplified "Standalone" and "Fully Distributed" mode) allowing you to run tests on different browser/OS combinations across multiple machines in parallel, reducing total execution time for large suites. The Hub receives test requests and routes them to an available matching Node.
//
//**Actions Class**: Used for complex user gestures not covered by basic WebElement methods — mouse hover (`moveToElement`), drag-and-drop (`dragAndDrop`/`clickAndHold`+`moveToElement`+`release`), right-click (`contextClick`), keyboard combos (`keyDown`/`keyUp` for Ctrl+Click, Shift+Click), double-click (`doubleClick`).
//
//**JavascriptExecutor**: Interface to run raw JS in the browser context via the driver — used for scrolling into view, clicking elements Selenium's native click can't reach (behind overlays), reading/setting values directly, and working with Shadow DOM before Selenium 4 added native support.
//
//## Q&A
//
//**Q9. What happens internally when you call `driver.get(url)`?**
//The client library serializes the command as a JSON payload and sends an HTTP POST request to the browser driver's local server; the driver translates it into a native OS-level browser command to navigate, then returns a response confirming the page load state.
//
//**Q10. Why do driver and browser versions need to match?**
//Because the browser driver (chromedriver etc.) is built against a specific browser version's internal automation API; mismatches cause `SessionNotCreatedException` or unpredictable failures — Selenium Manager (built into Selenium 4.6+) now auto-resolves this.
//
//**Q11. How do you handle a StaleElementReferenceException robustly in a framework?**
//Wrap the interaction in a retry loop that re-locates the element fresh each attempt (rather than reusing the old WebElement reference), typically for 2–3 retries with a short pause, or restructure the code to always locate immediately before use rather than caching elements.
//
//**Q12. What is the difference between `getWindowHandle()` and `getWindowHandles()`?**
//`getWindowHandle()` returns the unique ID (String) of the *current* window. `getWindowHandles()` returns a `Set<String>` of *all* open window/tab handles in the session — used to iterate and switch.
//
//**Q13. How do you handle a dropdown that is NOT a native `<select>` tag?**
//The `Select` class only works on `<select>` elements. For custom dropdowns (div/ul/li-based, common with React/Angular component libraries), click to open it, then use a locator (often dynamic XPath with `text()`) to click the specific option — sometimes requires waiting for the option list to render first.
//
//**Q14. Explain relative locators in Selenium 4 with an example.**
//```java
//WebElement passwordField = driver.findElement(
//    RelativeLocator.with(By.tagName("input")).below(By.id("username")));
//```
//This finds an `<input>` that is positioned below the username field on the page — useful when a field lacks a unique attribute but has a clear visual/DOM relationship to a nearby labeled element.
//
//**Q15. How do you scroll to an element in Selenium?**
//```java
//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//```
//Or using `Actions` class: `new Actions(driver).moveToElement(element).perform();`
//
//**Q16. How do you take a full-page vs element-specific screenshot?**
//Full page: `((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)`. Element-specific: call `.getScreenshotAs()` directly on the `WebElement` object (Selenium 4 supports this natively) rather than the whole driver.
//
//**Q17. What is the difference between `Thread.sleep()` and explicit wait — technically why is one worse?**
//`Thread.sleep()` is a hard, unconditional pause — wastes time if the condition is met earlier, and still fails if not met by the time it wakes up. Explicit wait polls conditionally and returns as soon as the condition is true, making it both faster on average and more reliable at the boundary.
//
//**Q18. How would you design a framework's WebDriver instantiation for parallel-safe execution?**
//Use `ThreadLocal<WebDriver>` so each test thread gets its own isolated driver instance, preventing one thread's browser session/state from leaking into another's — critical when running TestNG with `parallel="methods"` or `"classes"`.
//
//---
//---
//
//# TOPIC 3: PLAYWRIGHT — DEEP DIVE
//
//## Concepts
//
//**Architecture difference from Selenium**: Playwright doesn't use the WebDriver protocol at all. It communicates with browsers via each browser's own automation protocol (e.g., Chromium's DevTools Protocol) over a persistent WebSocket connection, giving it lower latency and more granular control (network interception, precise event dispatching) than Selenium's HTTP-per-command model.
//
//**Browser, Context, Page — the three-tier model** (core Playwright concept, likely to be asked):
//- **Browser**: One actual browser process (Chromium/Firefox/WebKit) launched once.
//- **BrowserContext**: An isolated "incognito-like" session within that browser — separate cookies/storage/cache. You can spin up many contexts from one browser instance cheaply, which is why Playwright parallelizes so efficiently (no need for a new full browser process per test).
//- **Page**: A single tab within a context. Multiple pages can exist in one context (e.g., simulating multi-tab flows).
//
//**Auto-waiting**: Before every action (click, fill, etc.), Playwright automatically waits for the element to be: attached to DOM, visible, stable (not animating), enabled, and receiving events (not obscured) — up to the configured timeout. This is why Playwright code rarely needs explicit wait statements compared to Selenium.
//
//**Web-First Assertions**: `expect(locator).toBeVisible()`, `.toHaveText()`, etc. — these *retry automatically* until the assertion passes or times out, unlike a one-shot assertion in traditional frameworks. This makes tests resilient to timing issues without manual waits.
//
//**Locators (modern, recommended approach)**:
//- `page.getByRole('button', { name: 'Submit' })` — accessibility-tree based, most resilient.
//- `page.getByText('Welcome')`
//- `page.getByLabel('Email')`
//- `page.getByPlaceholder('Enter your name')`
//- `page.getByTestId('submit-btn')` — for `data-testid` attributes.
//- CSS/XPath still supported via `page.locator('css=...')` but de-prioritized in favor of the above.
//
//**Fixtures**: Playwright Test's dependency-injection system. Built-in fixtures (`page`, `context`, `browser`, `request`) are auto-created/torn-down per test. **Custom fixtures** let you define reusable setup, e.g.:
//```typescript
//export const test = base.extend<{ loggedInPage: Page }>({
//  loggedInPage: async ({ page }, use) => {
//    await page.goto('/login');
//    await page.fill('#user', 'admin');
//    await page.fill('#pass', 'pass');
//    await page.click('#login-btn');
//    await use(page); // hand off to the test
//  },
//});
//```
//Any test using `loggedInPage` starts already authenticated — this is what your resume's "custom page fixtures" refers to.
//
//**Trace Viewer**: Configured via `trace: 'on-first-retry'` (or `'on'`) in `playwright.config.ts`. Captures a full timeline per test: DOM snapshots before/after each action, network requests, console logs, and screenshots — viewable in a visual timeline UI (`npx playwright show-trace trace.zip`) for debugging failures without re-running.
//
//**Parallelization model**: Configured via `workers` in `playwright.config.ts` — Playwright spins up multiple worker processes, each running test files (by default, one file = one worker unless sharded further), and within a worker, tests use isolated `BrowserContext`s so there's no shared state.
//
//**Network interception**: `page.route('**/api/data', route => route.fulfill({ json: mockData }))` — lets you mock/stub API responses directly at the browser network layer, useful for testing edge cases (errors, empty states) without needing backend support.
//
//**Playwright API Testing (`request` context)**:
//```typescript
//const response = await request.get('/api/users/1');
//expect(response.status()).toBe(200);
//const body = await response.json();
//expect(body.name).toBe('John');
//```
//This works independently of any browser page — pure HTTP client — often used to set up test data quickly before a UI test runs.
//
//## Q&A
//
//**Q19. Why is Playwright generally faster than Selenium?**
//It avoids the HTTP-request-per-command overhead of the WebDriver protocol by keeping a persistent WebSocket connection to the browser, and it reuses one browser process across many isolated `BrowserContext`s instead of spinning up a new browser per test.
//
//**Q20. What is the difference between BrowserContext and Page?**
//A `BrowserContext` is like a separate user session/profile (isolated cookies, storage) — you can have many per browser instance. A `Page` is a single tab within that context; a context can hold multiple pages (tabs).
//
//**Q21. How does Playwright achieve test isolation without launching a new browser every time?**
//Each test typically gets its own fresh `BrowserContext` (via the built-in `context`/`page` fixtures, recreated per test by default), which is lightweight compared to launching an entirely new browser process — giving isolation at a fraction of Selenium's per-test browser-launch cost.
//
//**Q22. What's the difference between `getByTestId()` and CSS/XPath locators, and why does Playwright recommend it?**
//`data-testid` attributes are added purely for testing purposes and don't change when developers restyle or restructure CSS classes/DOM hierarchy — making tests far less brittle than locators tied to implementation details like class names or DOM position.
//
//**Q23. Explain how you'd mock an API response in Playwright to test an error state.**
//```typescript
//await page.route('**/api/checkout', route =>
//  route.fulfill({ status: 500, body: JSON.stringify({ error: 'Server Error' }) })
//);
//await page.goto('/checkout');
//// assert error message is shown in UI
//```
//This lets you test how the UI handles a backend failure without needing the actual backend to be in that state.
//
//**Q24. How do you handle file download verification in Playwright?**
//```typescript
//const [download] = await Promise.all([
//  page.waitForEvent('download'),
//  page.click('#download-btn'),
//]);
//const path = await download.path();
//// verify file exists / read content
//```
//
//**Q25. How do you run the same test across multiple browsers in Playwright?**
//Define multiple `projects` in `playwright.config.ts` (e.g., chromium, firefox, webkit), each with its own `use: { browserName: ... }` — running `npx playwright test` executes the suite against all configured projects automatically.
//
//**Q26. What is Playwright's retry mechanism?**
//Configured via `retries` in config (e.g., `retries: 2`) — a failed test automatically re-runs up to N times; combined with `trace: 'on-first-retry'`, this captures a trace *only* on the retry that follows a failure, saving storage while still giving debug visibility.
//
//**Q27. How do you assert something is NOT visible / NOT present, and what's the risk of that assertion?**
//`await expect(locator).not.toBeVisible()` or `.toHaveCount(0)`. Risk: if the element simply hasn't rendered yet (timing), the assertion could pass prematurely — Playwright's auto-retry mitigates this by re-checking until the negative assertion is stably true or timeout is hit.
//
//---
//---
//
//# TOPIC 4: BDD, TDD & CUCUMBER — DEEP DIVE
//
//## Concepts
//
//**Why BDD exists**: Traditional test cases live in QA's head/tooling and are often disconnected from what the business actually asked for. BDD forces requirements to be expressed as concrete, testable examples in a shared language (Gherkin) *before* development finishes, so ambiguity is caught early and the same scenario document serves as living documentation, requirement, and automated test.
//
//**Gherkin keywords**:
//- `Feature` — groups related scenarios, describes the capability.
//- `Scenario` — one concrete example/test case.
//- `Given` — initial context/precondition.
//- `When` — the action/event.
//- `Then` — expected outcome.
//- `And` / `But` — continuation of previous keyword's step type.
//- `Background` — steps common to *every* scenario in a feature, run before each.
//- `Scenario Outline` + `Examples` — parameterized scenario run once per row of a data table (like a data-driven test).
//
//**Example of Scenario Outline:**
//```gherkin
//Scenario Outline: Login with different roles
//  Given the user is on the login page
//  When the user logs in as "<role>" with "<password>"
//  Then the user should see the "<dashboard>" dashboard
//
//  Examples:
//    | role  | password | dashboard |
//    | admin | admin123 | Admin     |
//    | staff | staff123 | Staff     |
//```
//
//**Step Definitions**: Java methods annotated `@Given`, `@When`, `@Then` whose text (regex or Cucumber Expression) matches the Gherkin step text. Cucumber uses this matching to find and execute the right method when running a scenario.
//
//**Cucumber + Selenium/Playwright architecture**:
//```
//Feature files (.feature)
//      ↓ matched by
//Step Definitions (Java/TS classes) 
//      ↓ call
//Page Object classes (POM)
//      ↓ drive
//Selenium/Playwright browser actions
//```
//
//**Hooks**: `@Before` runs before each scenario (commonly: launch browser, initialize driver). `@After` runs after (quit driver, attach screenshot on failure via `scenario.attach()`). Can be tag-scoped: `@Before("@api")` only runs before scenarios tagged `@api`.
//
//**Tags**: Labels on `Feature`/`Scenario` (e.g., `@smoke`, `@regression`, `@api`) used to selectively execute subsets via CLI/runner filters — critical for CI pipelines that run only `@smoke` on every PR but full `@regression` nightly.
//
//**Dependency Injection in Cucumber (PicoContainer)**: Since each step definition class is typically stateless and instantiated fresh, sharing data across steps (e.g., a value entered in "Given" needed in "Then") requires a shared context/"World" object injected into all step classes via PicoContainer or a similar DI framework.
//
//**Cucumber Reports**: Plugins like `cucumber-reporting` or `Cucumber HTML Reports` (via `@CucumberOptions(plugin = {"json:target/cucumber.json"})`) generate readable HTML reports from the JSON output, often integrated into Jenkins post-build steps.
//
//## Q&A
//
//**Q28. What's the real business value of BDD, beyond just "it's readable"?**
//It closes the gap between business intent and what gets tested — since scenarios are written collaboratively (three amigos: BA/Dev/QA) *before* coding starts, misunderstandings are caught at the requirement stage instead of after a feature is built wrong, reducing rework.
//
//**Q29. What is a Cucumber Expression vs Regex in step definitions?**
//Cucumber Expressions are a simpler, more readable syntax for common patterns (e.g., `{string}`, `{int}`) — `@Given("the user enters {string}")` — versus full regex (`@Given("^the user enters \"([^\"]*)\"$")`), which is more powerful but harder to read/maintain.
//
//**Q30. How do you avoid duplicate step definitions across large feature suites?**
//Design steps to be generic and reusable (parameterized rather than hardcoded), organize step definition classes by domain/module, and periodically review for near-duplicate wording that Cucumber's ambiguous-step-detection would flag at runtime.
//
//**Q31. What's the difference between `Background` and a `@Before` hook?**
//`Background` is written in Gherkin and its steps are visible in the feature file (part of the living documentation, shown in reports) — it runs before every scenario in that feature. `@Before` is a hook in code, invisible in the feature file, used for technical setup (browser launch) not meant to be part of the readable spec.
//
//**Q32. How do you run only smoke tests out of a full Cucumber suite in CI?**
//Tag smoke scenarios with `@smoke`, then run via CLI/Maven: `mvn test -Dcucumber.filter.tags="@smoke"`, or configure the Jenkins job to pass that tag filter as a parameter — letting the same codebase serve both quick PR checks and full nightly regression.
//
//**Q33. If BDD scenarios are meant for business readability, how do you keep step definitions from becoming too UI-implementation-specific?**
//Keep Gherkin steps behavior/business-focused ("When the user logs in") rather than UI-mechanical ("When the user clicks the button at id=login-btn") — implementation detail lives inside the step definition/Page Object, not in the Gherkin text, so the scenario stays stable even if the UI implementation changes.
//
//---
//---
//
//# TOPIC 5: API TESTING — DEEP DIVE (Postman, REST Assured, Playwright API)
//
//## Concepts
//
//**REST fundamentals**: REST (Representational State Transfer) is an architectural style using standard HTTP methods against resource-based URLs. Key principles: statelessness (each request is independent, server holds no client session state), resource-based URLs (`/users/123` not `/getUser?id=123`), and use of standard status codes to communicate outcome.
//
//**HTTP Methods & Idempotency**:
//| Method | Purpose | Idempotent? | Has Body? |
//|---|---|---|---|
//| GET | Retrieve | Yes | No |
//| POST | Create | No | Yes |
//| PUT | Full update/replace | Yes | Yes |
//| PATCH | Partial update | No (typically) | Yes |
//| DELETE | Remove | Yes | Usually no |
//
//*Idempotent* means calling it multiple times has the same effect as calling it once (GET/PUT/DELETE) — POST is not, since calling it twice typically creates two resources.
//
//**Status Code Categories**:
//- 1xx Informational (rare in testing)
//- 2xx Success — 200 OK, 201 Created, 204 No Content
//- 3xx Redirection — 301 Moved Permanently, 304 Not Modified
//- 4xx Client Error — 400 Bad Request, 401 Unauthorized (not authenticated), 403 Forbidden (authenticated but not allowed), 404 Not Found, 409 Conflict
//- 5xx Server Error — 500 Internal Server Error, 502 Bad Gateway, 503 Service Unavailable
//
//**Authentication types in API testing**:
//- **API Key** — sent as header/query param.
//- **Basic Auth** — base64-encoded username:password in header.
//- **Bearer Token / JWT** — `Authorization: Bearer <token>`, typically obtained via a login/token endpoint first.
//- **OAuth 2.0** — more complex flow (client credentials, authorization code) often involving a token exchange step before the actual API calls.
//
//**Postman concepts**:
//- **Collections** — grouped set of saved requests.
//- **Environments** — variable sets (e.g., `{{base_url}}`, `{{token}}`) swappable between Dev/QA/Prod without editing requests.
//- **Pre-request Scripts** — JS run *before* the request (e.g., generate a timestamp, fetch a fresh token).
//- **Tests tab (post-response scripts)** — JS assertions run after response (`pm.response.to.have.status(200)`, `pm.expect(jsonData.name).to.eql("John")`).
//- **Newman** — CLI runner for Postman collections, used to integrate Postman suites into CI/CD pipelines (Jenkins can invoke `newman run collection.json`).
//- **Chaining requests** — using `pm.environment.set("token", jsonData.token)` in one request's test script so later requests can reference `{{token}}`.
//
//**REST Assured concepts (Java)**:
//```java
//given()
//  .header("Authorization", "Bearer " + token)
//  .body(payload)
//.when()
//  .post("/api/users")
//.then()
//  .statusCode(201)
//  .body("name", equalTo("John"))
//  .time(lessThan(2000L));
//```
//Given-When-Then BDD-style syntax. Supports JSON schema validation (`matchesJsonSchemaInClasspath`), response time assertions, and easy chaining/extraction (`.extract().path("id")`).
//
//**JSON Schema Validation**: Rather than checking individual fields one by one, validate the *entire response structure* (required fields, data types, nested object shapes) against a predefined schema file — catches structural regressions (missing/renamed fields) that field-by-field checks might miss.
//
//**API Test Data Setup Strategy**: Instead of creating test data through slow UI flows, hit the API directly to seed data (e.g., create a test user via `POST /users` before running a UI test that needs that user to exist) — dramatically speeds up test setup and reduces UI test flakiness caused by unrelated UI bugs in the setup flow.
//
//## Q&A
//
//**Q34. What's the difference between 401 and 403 status codes?**
//401 Unauthorized means the request lacks valid authentication credentials at all (or they're invalid/expired). 403 Forbidden means the server understood who you are (you're authenticated) but you don't have permission to access that specific resource.
//
//**Q35. How do you test for negative/edge cases in API testing?**
//Missing required fields, invalid data types, boundary values (empty strings, very long strings, negative numbers where positive expected), invalid/expired auth tokens, malformed JSON, and unsupported HTTP methods on an endpoint — each should return an appropriate 4xx with a clear error message, not a 500 or silent failure.
//
//**Q36. How do you validate response time / performance at the API test level?**
//`response.time()` in Postman tests (`pm.expect(pm.response.responseTime).to.be.below(2000)`) or `.time(lessThan(2000L))` in REST Assured — set thresholds based on agreed SLAs, and flag/fail if consistently exceeded.
//
//**Q37. How would you test an API that depends on another API's output (chained dependency)?**
//Call the first API, extract the needed value (ID/token) from its response programmatically, inject it into the second request, and assert the second response — while also independently testing each API in isolation with mocked/stubbed inputs where possible to avoid cascading failures from unrelated upstream issues.
//
//**Q38. What's the difference between API testing and UI testing in terms of what bugs each catches?**
//API testing catches backend logic, data validation, and integration-layer bugs faster and more precisely (no UI rendering ambiguity). UI testing catches issues that only manifest through actual user interaction — rendering, JS behavior, browser-specific quirks, and the full integrated user journey — that pure API testing can't see.
//
//**Q39. How do you handle versioned APIs (v1 vs v2) in your test suite?**
//Parameterize the base path/version in config (`{{base_url}}/v2/users`), maintain separate test suites or tagged subsets per version if behavior differs meaningfully, and ensure backward-compatibility tests exist if v1 must still be supported during a migration period.
//
//**Q40. What is Newman and why would you use it over the Postman GUI in CI?**
//Newman is Postman's command-line collection runner — it lets you execute the exact same collection headlessly as part of an automated Jenkins/CI pipeline (no GUI needed), and outputs machine-readable results (JUnit/HTML) for reporting.
//
//---
//---
//
//# TOPIC 6: PERFORMANCE TESTING — DEEP DIVE (Gap area — study this extra carefully)
//
//## Concepts
//
//**Why it's different from functional testing**: Functional testing asks "does it work?" Performance testing asks "does it work *fast enough, for enough concurrent users, without breaking*?" It's measuring non-functional requirements — speed, scalability, stability under load.
//
//**Types of Performance Testing**:
//- **Load Testing** — simulate expected real-world concurrent user load, measure response times/throughput at that load to confirm it meets SLAs.
//- **Stress Testing** — push load beyond normal/expected capacity to find the breaking point and observe *how* it fails (graceful degradation vs crash).
//- **Spike Testing** — sudden, sharp burst of load (e.g., flash sale traffic) to see if the system handles rapid scale-up.
//- **Soak/Endurance Testing** — sustained moderate load over an extended period (hours/days) to catch memory leaks, connection pool exhaustion, or gradual performance degradation that short tests wouldn't reveal.
//- **Scalability Testing** — incrementally increase load while adding resources to determine how well the system scales horizontally/vertically.
//- **Volume Testing** — test with a large *volume of data* (not necessarily concurrent users) e.g., a database with millions of rows, to see query/response degradation.
//
//**Key Metrics**:
//- **Response Time** — time from request sent to response received; report percentiles (p50/p90/p95/p99), not just average, since averages hide slow outliers that affect real users.
//- **Throughput** — requests/transactions processed per second.
//- **Error Rate** — % of failed requests under load.
//- **Concurrent Users / Virtual Users (VUs)** — how many simulated users are active at once.
//- **Resource Utilization** — CPU, memory, disk I/O, network on the server side during the test, to correlate performance drops with resource saturation.
//- **Think Time** — simulated pause between user actions, to mimic realistic (not robotic back-to-back) usage patterns.
//
//**Common Tools**:
//- **JMeter** — open-source, GUI + CLI, widely used for HTTP/API load testing, supports distributed load generation.
//- **k6** — modern, developer-friendly, script tests in JavaScript, CLI-first, great for CI/CD integration.
//- **Gatling** — Scala-based, code-first, good reporting.
//- **LoadRunner** — enterprise-grade, commercial, feature-rich but expensive.
//
//**Where performance testing fits in the pipeline**: Ideally integrated into CI/CD as a *gate* — e.g., a k6 script runs against a staging environment on each release candidate, and the build fails if p95 response time or error rate exceeds a defined threshold, catching performance regressions before production.
//
//## Q&A
//
//**Q41. What's the difference between Load and Stress testing, in one sentence each?**
//Load testing confirms the system performs acceptably *at* expected capacity; stress testing finds *where* it breaks *beyond* expected capacity.
//
//**Q42. Why is average response time a misleading metric on its own?**
//A few very slow outlier requests can be masked by many fast ones when averaged — e.g., an average of 500ms could hide that 5% of users experience 5-second waits; percentile metrics (p95/p99) surface that tail-latency problem that averages hide.
//
//**Q43. What would a basic performance test script structure look like (conceptually, e.g., in k6)?**
//Define virtual users (VUs) and duration/stages (ramp-up, sustain, ramp-down), define the HTTP requests representing a user journey (e.g., login → search → checkout), add `checks` (assertions like status==200), and set `thresholds` (e.g., `p(95)<2000` for response time, error rate `<1%`) that fail the test run if breached.
//
//**Q44. How would you identify the root cause if a performance test shows degradation?**
//Correlate the load-testing tool's client-side metrics (response time spikes) with server-side monitoring (CPU/memory/DB query times/connection pool usage) during the same time window — often the bottleneck is a slow DB query, insufficient connection pooling, or a specific under-optimized endpoint, identifiable by isolating which specific request type slows down first as load increases.
//
//**Q45. If you've never run a performance test hands-on, how do you answer this in the interview?**
//Be honest but show conceptual command: "I haven't run performance tests in production projects yet, but I understand load/stress/spike/soak testing concepts, key metrics like p95/throughput, and tools like JMeter/k6 — I'd be glad to get hands-on with this as part of the role." Confidence about *concepts* while being honest about *hands-on gaps* lands much better than pretending.
//
//---
//---
//
//# TOPIC 7: TESTNG & FRAMEWORK DESIGN — DEEP DIVE
//
//## Concepts
//
//**Annotation execution order** (must be memorized exactly):
//```
//@BeforeSuite
//  @BeforeTest
//    @BeforeClass
//      @BeforeMethod
//        @Test
//      @AfterMethod
//    @AfterClass
//  @AfterTest
//@AfterSuite
//```
//`@BeforeMethod`/`@AfterMethod` run around *every* `@Test`. `@BeforeClass`/`@AfterClass` run once per class. `@BeforeTest`/`@AfterTest` run once per `<test>` tag in testng.xml (which can span multiple classes). `@BeforeSuite`/`@AfterSuite` run once for the entire suite run.
//
//**testng.xml structure**:
//```xml
//<suite name="RegressionSuite" parallel="classes" thread-count="3">
//  <test name="LoginTests">
//    <classes>
//      <class name="tests.LoginTest"/>
//    </classes>
//  </test>
//</suite>
//```
//`parallel` attribute can be `methods`, `classes`, `tests`, or `instances` — controls the granularity of parallel execution.
//
//**DataProvider**:
//```java
//@DataProvider(name = "loginData")
//public Object[][] getData() {
//  return new Object[][] { {"user1","pass1"}, {"user2","pass2"} };
//}
//
//@Test(dataProvider = "loginData")
//public void loginTest(String user, String pass) { ... }
//```
//TestNG runs `loginTest` once per row, enabling data-driven testing without duplicating test method code.
//
//**Groups**: `@Test(groups = {"smoke"})` lets you logically tag tests (similar to Cucumber tags) and selectively run/exclude groups via `testng.xml`'s `<groups><run><include name="smoke"/></run></groups>`.
//
//**Listeners**: Classes implementing `ITestListener` (with methods like `onTestFailure`, `onTestSuccess`) hook into the test lifecycle — commonly used to auto-capture a screenshot on failure or to log custom reporting, registered via `@Listeners(MyListener.class)` or in testng.xml.
//
//**IRetryAnalyzer**: 
//```java
//public class RetryAnalyzer implements IRetryAnalyzer {
//  int count = 0;
//  int maxRetry = 2;
//  public boolean retry(ITestResult result) {
//    if (count < maxRetry) { count++; return true; }
//    return false;
//  }
//}
//```
//Applied via `@Test(retryAnalyzer = RetryAnalyzer.class)` — automatically re-attempts a failed test up to `maxRetry` times, useful for genuinely flaky (timing-related) failures — but should never be used to mask a real, consistent bug.
//
//**Assertions — Hard vs Soft**:
//- **Hard Assert** (`Assert.assertEquals()`) — stops test execution immediately on first failure.
//- **Soft Assert** (`SoftAssert`) — collects multiple assertion failures throughout a test and reports all of them together at the end via `softAssert.assertAll()` — useful when you want to check multiple independent things in one test run without stopping at the first failure.
//
//## Q&A
//
//**Q46. When would you use Soft Assert over Hard Assert?**
//When validating multiple independent UI elements on one page (e.g., checking 5 different field values after a form submission) — you want to know *all* the mismatches in one run rather than stopping at the first and having to re-run repeatedly to find the next failure.
//
//**Q47. What's the risk of overusing IRetryAnalyzer?**
//It can mask genuine, consistent bugs or real flakiness that needs fixing (e.g., a real race condition in the app) by silently passing on a later retry — retries should be reserved for known environmental/timing flakiness, with the underlying flaky cause still being actively investigated and fixed, not permanently papered over.
//
//**Q48. How do Groups in TestNG help in a CI pipeline?**
//You can configure a PR-triggered Jenkins job to run only `smoke`-grouped tests (fast feedback, few minutes) while a nightly job runs the full `regression` group (comprehensive, longer) — balancing speed and coverage across the pipeline.
//
//**Q49. How would you design a Base Test class in your framework?**
//A `BaseTest` class holding common `@BeforeMethod`/`@AfterMethod` logic (driver setup/teardown, navigating to base URL, login if needed) that all test classes extend — avoiding duplicated setup code and centralizing changes (e.g., switching browser config) to one place.
//
//---
//---
//
//# TOPIC 8: CORE JAVA / OOPS — DEEP DIVE
//
//## Concepts
//
//**Four Pillars of OOPS, mapped to automation framework design:**
//1. **Encapsulation** — bundling data (WebElements/locators) with the methods that operate on them, hiding internal details. Page Object classes are the textbook example: locators are `private`, only action methods (`login()`, `clickSubmit()`) are exposed.
//2. **Inheritance** — a class acquiring properties/methods of another. `BasePage` holds common methods (`waitForElement()`, `takeScreenshot()`); every specific page class (`LoginPage extends BasePage`) inherits these without rewriting them.
//3. **Polymorphism** — same method name behaving differently. *Overloading* (compile-time): multiple `login()` methods with different parameter lists. *Overriding* (runtime): a subclass provides its own implementation of a parent's method, e.g., overriding a generic `verifyPageLoaded()` per page.
//4. **Abstraction** — exposing only essential behavior via interfaces/abstract classes, hiding implementation. E.g., an interface `PaymentPage` with a `completePayment()` method, implemented differently for Credit Card vs UPI flows, while calling test code just calls `.completePayment()` without knowing which implementation runs.
//
//**Collections Framework (what's actually used in automation)**:
//- **List (ArrayList)** — ordered, allows duplicates; used for storing `List<WebElement>` from `findElements()`, or ordered test data rows.
//- **Set (HashSet)** — no duplicates, unordered; used to verify uniqueness (e.g., confirming a dropdown has no duplicate entries).
//- **Map (HashMap)** — key-value pairs; used for config data, or mapping expected vs actual values by key for comparison.
//- **Iterator** — used to loop through collections, especially when removal during iteration is needed (`Iterator.remove()`).
//
//**Exception Handling**:
//- **Checked exceptions** — must be declared (`throws`) or caught at compile time (e.g., `IOException`, `SQLException`) — the compiler forces you to acknowledge them.
//- **Unchecked exceptions (RuntimeException subclasses)** — not enforced by compiler (e.g., `NullPointerException`, `NoSuchElementException`, `ArrayIndexOutOfBoundsException`) — most Selenium-specific exceptions fall here.
//- **try-catch-finally** — `finally` block always executes (used for cleanup like closing a DB connection or driver, regardless of exception).
//- **Custom Exceptions** — creating your own exception class extending `Exception`/`RuntimeException` for framework-specific error signaling (e.g., a `FrameworkConfigException` if a required config value is missing).
//
//**Multithreading relevance in automation**: Parallel test execution means multiple test threads may run simultaneously. Since a single `WebDriver` instance is NOT thread-safe (one instance controls one browser), each thread must have its own instance — achieved via `ThreadLocal<WebDriver>`, which gives each thread its own isolated copy of a variable, preventing cross-thread interference.
//
//**String handling nuances often asked**: `String` is immutable in Java (each modification creates a new object) — relevant when building dynamic XPath strings in a loop; `StringBuilder` is preferred for heavy string concatenation in loops for performance, since it's mutable.
//
//## Q&A
//
//**Q50. Why is `WebDriver` not thread-safe, and how do you solve it practically?**
//A single `WebDriver` instance maintains state tied to one browser session; if two threads share it, their commands interleave unpredictably against the same browser. Solution: `ThreadLocal<WebDriver> driver = new ThreadLocal<>();` — set/get the driver per-thread so each parallel test thread has its own isolated browser instance.
//
//**Q51. What's the difference between an Abstract class and an Interface in Java, and when would you use each in a framework?**
//Abstract class can have both implemented and abstract methods, plus state (fields), and supports single inheritance — good for a `BasePage` with shared implemented utility methods. Interface (pre-Java 8) only declares method signatures (now can have default methods too) and supports multiple inheritance — good for defining a contract like `Loadable { boolean isPageLoaded(); }` that multiple unrelated page classes can implement.
//
//**Q52. Explain method overloading vs overriding with a testing-relevant example.**
//Overloading: `public void login(String user, String pass)` and `public void login(String user, String pass, boolean rememberMe)` in the same class — same name, different parameters, resolved at compile time. Overriding: `LoginPage` overrides a `verifyPageLoaded()` method inherited from `BasePage` to check for a login-specific element, resolved at runtime based on actual object type.
//
//**Q53. Why would you use `HashMap` over `List` for storing expected test data?**
//When you need to look up a value by a meaningful key quickly (e.g., `expectedData.get("email")`) rather than remembering positional index in a list — improves readability and reduces errors from index misalignment.
//
//**Q54. What's a real example of a checked exception you'd handle in an automation framework?**
//Reading test data from an Excel file via Apache POI or a properties file via `FileInputStream` throws `IOException` (checked) — you must wrap it in try-catch (often re-throwing as an unchecked custom exception) so it doesn't force every calling method up the chain to also declare `throws IOException`.
//
//---
//---
//
//# TOPIC 9: SQL / MYSQL — DEEP DIVE
//
//## Concepts
//
//**Why QA needs SQL**: To validate backend data integrity independent of (and often faster than) the UI — e.g., confirming a payroll calculation stored in the DB is correct, without needing to click through the UI to see it, and to set up/clean up test data directly.
//
//**Core clause order** (important, often tested): `SELECT columns FROM table WHERE condition GROUP BY column HAVING group_condition ORDER BY column`.
//- `WHERE` filters rows *before* grouping; `HAVING` filters *after* grouping (used with aggregate functions).
//
//**JOIN types**:
//- **INNER JOIN** — only rows with matches in both tables.
//- **LEFT JOIN** — all rows from left table + matched rows from right (unmatched right columns = NULL).
//- **RIGHT JOIN** — mirror of LEFT JOIN.
//- **FULL OUTER JOIN** — all rows from both, matched where possible (not natively supported in MySQL, simulated via `UNION` of LEFT and RIGHT JOIN).
//- **SELF JOIN** — a table joined to itself, e.g., finding employees who share the same manager.
//
//**Aggregate functions**: `COUNT()`, `SUM()`, `AVG()`, `MIN()`, `MAX()` — commonly used to validate computed totals (e.g., `SUM(deductions)` should equal a UI-displayed total deduction figure).
//
//**Primary Key vs Foreign Key**: Primary Key uniquely identifies each row in its own table (no duplicates, not null). Foreign Key is a column in one table referencing another table's Primary Key, enforcing relational integrity (e.g., `payroll.employee_id` references `employees.id`).
//
//**Common QA validation query pattern**:
//```sql
//SELECT e.name, p.net_salary 
//FROM employees e 
//JOIN payroll p ON e.id = p.employee_id 
//WHERE p.month = '2025-06' AND e.department = 'Engineering';
//```
//Used to cross-check a specific UI-displayed payroll report against actual DB-stored values.
//
//**Transactions & ACID (good-to-know conceptually)**: Atomicity, Consistency, Isolation, Durability — properties ensuring DB operations complete fully or not at all, relevant when testing scenarios involving concurrent updates or rollback behavior (e.g., verifying a failed payment doesn't partially update an order record).
//
//## Q&A
//
//**Q55. Write a query to find duplicate entries in a column (e.g., duplicate employee emails).**
//```sql
//SELECT email, COUNT(*) 
//FROM employees 
//GROUP BY email 
//HAVING COUNT(*) > 1;
//```
//
//**Q56. What's the difference between `WHERE` and `HAVING`?**
//`WHERE` filters individual rows before any grouping occurs and cannot reference aggregate functions. `HAVING` filters *groups* after `GROUP BY` has been applied and can reference aggregate functions like `COUNT()`/`SUM()`.
//
//**Q57. How would you validate that a UI-displayed total matches the database?**
//Run an aggregate query (e.g., `SELECT SUM(amount) FROM transactions WHERE user_id = X`) directly against the DB, capture the UI-displayed total via automation, and assert programmatically that the two values are equal within the test.
//
//**Q58. What is normalization and why does it matter for a QA to understand it?**
//Normalization is structuring a DB to reduce data redundancy and improve integrity (splitting data into related tables rather than one flat table). QA relevance: understanding normalized schema helps you write correct multi-table validation JOINs and understand where a data bug might actually originate (e.g., a stale foreign key reference).
//
//**Q59. How do you clean up test data after an automated test run to keep the DB consistent?**
//Either wrap test data creation/deletion in the test itself (`@AfterMethod`/`@AfterEach` deletes what was created), use a dedicated test/staging DB that's reset periodically, or use DB transactions that roll back automatically after each test where supported.
//
//---
//---
//
//# TOPIC 10: GIT, CI/CD, DOCKER, LINUX — DEEP DIVE
//
//## Concepts
//
//**Git branching model commonly used**: `main`/`master` (production-ready), `develop` (integration branch), `feature/*` branches (per feature/bug, branched off develop, merged back via Pull Request after review) — sometimes simplified to trunk-based (`main` + short-lived feature branches) in smaller teams.
//
//**Merge vs Rebase**:
//- `git merge` — combines two branches' histories with a new merge commit; preserves full, non-linear history (safe for shared branches).
//- `git rebase` — replays your branch's commits on top of the target branch, producing a clean linear history but *rewrites commit hashes* — should never be done on a branch others are actively working from (shared/public branch), since it breaks their history alignment.
//
//**Common conflict resolution flow**: `git pull` (or fetch+merge) → conflict markers (`<<<<<<`, `======`, `>>>>>>`) appear in affected files → manually resolve → `git add <file>` → `git commit` to finalize the merge.
//
//**CI/CD pipeline stages (typical for a test automation Jenkins job)**:
//1. **Checkout** — pull latest code from Git.
//2. **Build/Install** — `mvn install` / `npm install` (dependencies).
//3. **Test Execution** — run automation suite (often headless, parallel, tagged subset like `@smoke` for PR checks).
//4. **Report Publishing** — generate/publish HTML report (Extent/Allure/Cucumber reports) as a Jenkins build artifact.
//5. **Notification** — Slack/email alert on failure, often with report link attached.
//
//**Jenkins concepts**: **Freestyle jobs** (GUI-configured, simpler) vs **Pipeline jobs** (`Jenkinsfile`, code-as-config, supports complex multi-stage logic, version-controlled alongside the codebase — generally preferred for maintainability). **Triggers**: can be poll-SCM (checks Git periodically), webhook-based (Git triggers Jenkins immediately on push/PR), or scheduled (cron-like, e.g., nightly full regression at 2 AM).
//
//**Docker concepts relevant to QA**:
//- **Image** — a read-only template/blueprint (e.g., `selenium/standalone-chrome`).
//- **Container** — a running instance of an image, isolated from the host and other containers.
//- **Dockerfile** — script defining how to build a custom image (base image + dependencies + commands).
//- **docker-compose** — defines and runs *multi-container* setups (e.g., app + DB + Selenium Grid nodes together) via a single YAML file — useful for spinning up a full test environment reproducibly.
//- **Why QA cares**: Running Selenium Grid nodes in Docker containers ensures every CI run gets identical, clean browser environments (no "works on my machine" drift), and containers are cheap to spin up/tear down per pipeline run.
//
//**Linux essentials for a QA/SDET**:
//- Navigation: `ls`, `cd`, `pwd`
//- File inspection: `cat`, `less`, `head`, `tail -f` (live-follow a log file — very useful for watching a test run's log in real time)
//- Search: `grep "ERROR" logfile.log` (find specific lines, e.g., failures in a huge log)
//- Permissions: `chmod +x script.sh` (make a script executable)
//- Process management: `ps aux`, `kill -9 <pid>` (e.g., killing a hung browser/driver process left over from a crashed test run)
//- Networking/quick checks: `curl -I <url>` (quick status-code check), `ping`
//
//## Q&A
//
//**Q60. When would you choose `git rebase` over `git merge`, and when is it dangerous?**
//Rebase is good for cleaning up your *own local, not-yet-shared* feature branch before opening a PR (linear, readable history). It's dangerous on a branch others have already pulled/based work on, since rewriting commit history breaks their local copies and causes painful conflicts on their next pull.
//
//**Q61. How would you set up a Jenkins pipeline to run smoke tests on every PR and full regression nightly?**
//Two separate Jenkins jobs (or one parameterized pipeline): one triggered by a GitHub webhook on PR open/update, running a `@smoke`-tagged subset for fast feedback (minutes); another on a cron schedule (e.g., nightly), running the full `@regression` suite with complete reporting, since it can afford to take longer.
//
//**Q62. Why would you run Selenium Grid nodes as Docker containers instead of installing browsers directly on Jenkins agents?**
//Ensures a clean, consistent, reproducible browser environment for every test run (no leftover state/version drift between runs), makes it trivial to scale nodes up/down, and avoids polluting/depending on the Jenkins agent machine's local browser installations, which are hard to keep in sync across multiple agents.
//
//**Q63. How do you debug a test that's hanging/stuck in a CI pipeline?**
//Check Jenkins console output/logs for the last executed step, look for a leftover browser/driver process not being killed (`ps aux | grep chrome`), verify no explicit wait/timeout is set too high or infinite, and check if it's an environment-specific issue (headless mode differences, resource constraints on the CI agent) versus a genuine app-under-test issue.
//
//**Q64. What is the purpose of a `.gitignore` file in an automation framework repo?**
//Prevents committing files that shouldn't be in version control — build artifacts (`target/`, `node_modules/`), IDE config (`.idea/`), local environment/config files with secrets, and generated reports/screenshots — keeping the repo clean and avoiding accidental credential leaks.
//
//---
//---
//
//# FINAL: HOW TO USE THIS DOCUMENT TONIGHT
//
//1. **Read each Concept section first, out loud if possible** — the goal is being able to *explain* it in your own words, not recite it.
//2. **Cover the Q&A and try answering from memory**, then check against the written answer — repeat for anything you stumbled on.
//3. **Prioritize by JD weight**: Playwright + Selenium (Topic 2, 3) and API Testing (Topic 5) are your strongest ground — nail those completely. Performance Testing (Topic 6) is your gap — know the *concepts* cold even without hands-on experience.
//4. **Don't memorize word-for-word** — interviewers can tell. Understand the "why" behind each concept so you can adapt the answer to however they phrase the question.
//5. Re-check your original resume metrics (25%, 40%, 30%, 35%, 150+, 200+) one more time before you sleep — these get asked in almost every follow-up.
//
//Good luck tomorrow.
