# POC Of a Modularized Architecture

```
                       +---------------------+
                       |                     |
                       |                     |
       +--------------+|         app         +-----------+
       |               |                     |           |
       |               |                     |           |
       |               |                     |           |
       |               +----------+----------+           |
       |                          |                      |
       |                          |                      |
       |                          |                      |
       |                          |                      |
       |                          |                      |
+------+------+           +-------+------+        +------+------+
|             |           |              |        |             |
|   :users    |           |   :user      |        |   :login    |
|             +---+       |              |    +---+             |
|             |   |       |              |    |   |             |
+------+------+   |       +-------+------+    |   +--------+----+
       |          |               |           |            |
       |          |               |           |            |
       |          |               |           |            |
       |          |               |           |            |
       |          |    +----------+--------+  |            |
       |          |    |                   |  |            |
       |          +----+   :user-model     +--+            |
       |               |                   |               |
       |               +-------------------+               |
       |                                                   |
       |                                                   |
       |                                                   |
       |                                                   |
+------+---------------------------------------------------+-----+
|                                                                |
|                                                                |
|                              :base                             |
|                                                                |
|                                                                |
+----------------------------------------------------------------+

```


**app:** The composed application that would be built and packaged as apk. It has all the feature related modules.

**user-model:** A **shared** module to be used by `user` related feature. Essentially a `user` model class.

**user:** A feature module for showing a particular user details. This module has the `base` and `user-model` modules.

**users:** A feature module for showing a list of users. This module has the `base` and `user-model` modules as well.

**login:** A feature module for allowing a user to login. This module has the `base` and `user-model` modules.

**base:** A shared module to be used by all feature related modules.


# Navigation

[Deep link](https://developer.android.com/training/app-links/deep-linking) handles all the navigations

There's an `AppNavigation` class in the base module navigating users to the different screens. This is solely using deep links for launching all `Activities`

# Sample Demo

<img src="screenshot/sample-demo.gif?raw=true" width="300" />