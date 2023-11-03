#!/usr/bin/env -S v

// Note: The shebang line above, associates the .vsh file to V on Unix-like systems,
// so it can be run just by specifying the path to the .vsh file, once it's made
// executable, using `chmod +x deploy.vsh`, i.e. after that chmod command, you can
// run the .vsh script, by just typing its name/path like this: `./deploy.vsh`
// print command then execute it.
fn sh(cmd string) {
	println('> ${cmd}')
	println(execute_or_exit(cmd).output)
}

// remove if build/ exists ignore any errors if it does not exist
rmdir_all('build') or {}

// create build/ never fails as build/ does not exist
mkdir('build') or {}

// Move *.v files to build/ directory
result := execute('mv *.v build/')
if result.exit_code != 0 {
	println(result.output)
}

sh('ls')
