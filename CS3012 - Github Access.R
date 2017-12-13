library(jsonlite)
library(httpuv)
library(httr)

oauth_endpoints("github")

myapp <- oauth_app(appname = "Software Engineering",
                   key = "74c4f0d911b3033d8f19",
                   secret = "a0365982bebe23856caf55b12f26b47e98cbea4d")

github_token <- oauth2.0_token(oauth_endpoints("github"), myapp)

gtoken <- config(token = github_token)

githubUrl = "https://api.github.com"

