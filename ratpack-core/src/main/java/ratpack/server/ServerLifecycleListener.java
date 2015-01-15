/*
 * Copyright 2015 the original author or authors.
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

package ratpack.server;

/**
 * Defines an object that participates in server lifecycle events.
 */
public interface ServerLifecycleListener {

  /**
   * Server startup event.
   * Executed after the root registry and server instance are constructed and before the server begins accepting requests.
   *
   * @param event meta information about the startup event.
   * @throws Exception any exception thrown from this method
   */
  default void onStart(StartEvent event) throws Exception { }

  /**
   * Server stop event.
   * Executed after the root handler stops accepting requests and before the server closes the channel and thread pool.
   *
   * @param event meta information about the stop event.
   * @throws Exception any exception thrown from this method
   */
  default void onStop(StopEvent event) throws Exception { }
}