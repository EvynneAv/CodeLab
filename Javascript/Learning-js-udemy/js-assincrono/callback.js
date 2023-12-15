const loginUser = (email, password, callback, onError) => {
  setTimeout(() => {
    const error = false;

    if (error) {
      return onError(new Error('error in login!'));
    }

    console.log('user logged!');
    callback({ email });
  }, 1500);
};

const getUserVideos = (video, callback) => {
  setTimeout(() => {
    callback(['video1', 'video2', 'video3']);
  }, 2500);
};

const getVideoDetails = (video, callback) => {
  setTimeout(() => {
    callback({ title: 'video title' });
  });
};

const user = loginUser(
  'evynneav@gmail.com',
  '123456',
  (user) => {
    console.log({ user });
    getUserVideos(user.email, (videos) => {
      getVideoDetails(videos[0], () => {});
    });
  },
  (error) => {
    console.log({ error });
  },
);
