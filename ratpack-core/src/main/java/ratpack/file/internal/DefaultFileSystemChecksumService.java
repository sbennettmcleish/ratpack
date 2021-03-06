/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.file.internal;

import ratpack.api.Nullable;
import ratpack.file.FileSystemBinding;
import ratpack.file.FileSystemChecksumService;
import ratpack.func.Function;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DefaultFileSystemChecksumService implements FileSystemChecksumService {

  private final Function<? super InputStream, ? extends String> checksummer;
  private final FileSystemBinding fileSystemBinding;

  public DefaultFileSystemChecksumService(FileSystemBinding fileSystemBinding, Function<? super InputStream, ? extends String> checksummer) {
    this.checksummer = checksummer;
    this.fileSystemBinding = fileSystemBinding;
  }

  @Nullable
  @Override
  public String checksum(String path) throws Exception {
    Path child = fileSystemBinding.file(path);
    return getChecksum(child);
  }

  private String getChecksum(Path child) throws Exception {
    try (InputStream inputStream = Files.newInputStream(child, StandardOpenOption.READ)) {
      return checksummer.apply(inputStream);
    }
  }

}
