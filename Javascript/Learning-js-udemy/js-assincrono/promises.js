const loginUser = (email, password) => {
  return new Promise((resolve, reject) => {
    const error = false;

    if (error) {
      reject(new Error('error in login'));
    }

    console.log('user logged!');
    resolve({ email });
  });
};
const getUserVideos = (email) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log('getUserVideos');
      resolve(['video', 'video2', 'video3']);
    }, 2000);
  });
};

const getVideoDetails = (video) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log('getVideoDetails');
      resolve({ title: 'video title' });
    }, 2500);
  });
};

// loginUser('eynneave@gmail.com', '123456')
//   .then((user) => getUserVideos(user.email))
//   .then((videos) => getVideoDetails(videos[0]))
//   .catch((error) => console.log({ error }));

const yt = new Promise((resolve) => {
  setTimeout(() => {
    resolve('videos from youtube');
  }, 2000);
});

const fb = new Promise((resolve) => {
  setTimeout(() => {
    resolve('posts from facebook');
  }, 3000);
});

Promise.all([yt, fb]).then((result) => {
  console.log({ result });
});
