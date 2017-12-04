import static org.junit.Assert.fail;
        .matchesNext(MessageType.PROGRESS, "Git Destination: Fetching: file:.* refs/heads/master")
        .matchesNext(MessageType.WARNING,
            "Git Destination: 'refs/heads/master' doesn't exist in 'file://.*")
    thrown.expectMessage("'refs/heads/testPullFromRef' doesn't exist");

    // Wait a second so that the git log history is ordered.
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      fail("Interrupted while waiting: " + e.getMessage());
    }
    branchChange(scratchTree, scratchRepo, "b2", "b2-1\n\n"
        + DummyOrigin.LABEL_NAME + ": b2-origin");
    branchChange(scratchTree, scratchRepo, "b2", "b2-2");