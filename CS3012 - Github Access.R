library(jsonlite)
library(httpuv)
library(httr)


oauth_endpoints("github")

myapp <- oauth_app(appname = "Software Engineering",
                   key = "74c4f0d911b3033d8f19",
                   secret = "a0365982bebe23856caf55b12f26b47e98cbea4d")

github_token <- oauth2.0_token(oauth_endpoints("github"), myapp)

gtoken <- config(token = github_token)

req <- GET("https://api.github.com/users/osullr", gtoken)

stop_for_status(req)

json1 = content(req)

gitDF = jsonlite::fromJSON(jsonlite::toJSON(json1))


#Source:https://towardsdatascience.com/accessing-data-from-github-api-using-r-3633fb62cb08



followingData = GET("https://api.github.com/users/defunkt/following", gtoken )
followingDataContent = content(followingData)
followingDataDF = jsonlite::fromJSON(jsonlite::toJSON(followingDataContent))

followingID = followingDataDF$login
userIDs = c(followingID)
allUsers = c()
usersDF = data.frame(Username = integer(), Following = integer(), Followers = integer(), Repositories = integer())


for(i in 1:length(userIDs)){
  following_url = paste("https://api.github.com/users/", userIDs[i], "/following", sep = "")
  following = GET(following_url, gtoken)
  followingContent = content(following)
  followingDF = jsonlite::fromJSON(jsonlite::toJSON(followingContent))
  followingLogin = followingDF$login
  
  
  for(j in 1:length(followingLogin)){
    if(is.element(followingLogin[j], allUsers) == FALSE){
      allUsers[[length(allUsers)+1]]=followingLogin[j]
      
      followers_url = paste("https://api.github.com/users/", followingLogin[j], sep = "")
      followers = GET(followers_url, gtoken)
      followersContent = content(followers)
      followersDF = jsonlite::fromJSON(jsonlite::toJSON(followersContent))
      
      numberFollowing = followingDF$following
      numberFollowers = followersDF$followers
      
      numberRepos = followersDF$public_repos
      
      usersDF[nrow(usersDF)+1,] = c(followingLogin[j], numberFollowing, numberFollowers, numberRepos)
      }
  }
}
