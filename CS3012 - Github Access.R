library(jsonlite)
library(httpuv)
library(httr)

oauth_endpoints("github")

myapp <- oauth_app(appname = "Software Engineering",
                   key = "74c4f0d911b3033d8f19",
                   secret = "a0365982bebe23856caf55b12f26b47e98cbea4d")

github_token <- oauth2.0_token(oauth_endpoints("github"), myapp)

gtoken <- config(token = github_token)

github_url = "https://api.github.com"
users_url = "https://api.github.com/users"
repository_url = "https://api.github.com/users/repos"  

req <- GET("https://api.github.com/users/osullr", gtoken)

stop_for_status(req)

json1 = content(req)

gitDF = jsonlite::fromJSON(jsonlite::toJSON(json1))


#Source:https://towardsdatascience.com/accessing-data-from-github-api-using-r-3633fb62cb08


followersData = GET("https://api.github.com/users/osullr/followers", gtoken)
followersID = followersData$login
followersIDs = c(followersID)
totalFollowers = c()



for(i in 1:length(totalFollowers)){
  url = paste("https://api.github.com/users", followersIDs[i], "/followers", sep = "")
  followers = fromJSON(url)
  followersLogin = followers$login
  for(j in 1:length(followersLogin)){
    if(is.element(followersLogin[j], totalFollowers) == FALSE){
      totalFollowers[[length(totalFollowers)+1]]=followersLogin[j]
    }
    next
  }
  next
}


followingData = GET("https://api.github.com/users/osullr/following", gtoken)
followingID = followingData$login
followingIDs = c(followingID)
totalFollowing = c()

for(i in 1:length(totalFollowing)){
  url = paste("https://api.github.com/users", followingIDs[i], "/following", sep = "")
  following = fromJSON(url)
  followingLogin = following$login
  for(j in 1:length(followingLogin)){
    if(is.element(followingLogin[j], totalFollowing) == FALSE){
      totalFollowing[[length(totalFollowing)+1]]=followingLogin[j]
    }
    next
  }
  next
}
